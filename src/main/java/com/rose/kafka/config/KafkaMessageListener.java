package com.rose.kafka.config;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rose.kafka.model.DeleteVo;
import com.rose.kafka.model.EditVo;
import com.rose.kafka.util.HomepageConfig;
import com.rose.kafka.util.SpringUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class KafkaMessageListener implements AcknowledgingMessageListener<Integer,String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageListener.class);

    JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.getBean("jdbcTemplate");
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    @Override
    public void onMessage(ConsumerRecord<Integer, String> record, Acknowledgment acknowledgment) {
        LOGGER.info("kafka的key: " + record.key());
        LOGGER.info("kafka的offset: " + record.offset());
        LOGGER.info("kafka的partition: " + record.partition());
        LOGGER.info("kafka的value: " + record.value().toString());

        JSONObject jsonObject = JSON.parseObject(record.value().toString());
        String type = jsonObject.getString("type");

        boolean isConsumered = false;
            if("EDIT".equals(type) || "ADD".equals(type)){
                EditVo editVo = JSON.toJavaObject((JSON) JSON.parse(record.value().toString()), EditVo.class);;
                try{
                    Class aClass = Class.forName("cn.sinobest.jzpt.send.model." + editVo.getTableName());
                    Object o = JSON.toJavaObject((JSON) JSON.parse(editVo.getDataStr()), aClass);

                    isConsumered = isConsumeredMessage(editVo.getSjkbs(),editVo.getTableName(),editVo.getIdVal(),editVo.getCreatetime());
                    if(isConsumered){
                        acknowledgment.acknowledge();//手动提交偏移量
                        //记录日志
                        saveConsumeredMessageLog(editVo.getTableName(),editVo.getIdVal(),editVo.getCreatetime(),
                                editVo.getType(),null,"1", String.valueOf(record.offset()));
                        return;
                    }
                    CrudRepository crudRepository = (CrudRepository) SpringUtil.getBean(editVo.getTableName() + "Repository");
                    crudRepository.save(o);

                    //记录日志
                    saveConsumeredMessageLog(editVo.getTableName(),editVo.getIdVal(),editVo.getCreatetime(),
                            editVo.getType(),null,"1", String.valueOf(record.offset()));
                    acknowledgment.acknowledge();//手动提交偏移量
                }catch(Exception e){
                    e.printStackTrace();
                    //记录日志
                    saveConsumeredMessageLog(editVo.getTableName(),editVo.getIdVal(),editVo.getCreatetime(),
                            editVo.getType(),null,"0", String.valueOf(record.offset()));
                    LOGGER.error("数据保存到数据库过程出错！");
                }

            }else if("DELETE".equals(type )){
                DeleteVo deleteVo = JSON.toJavaObject((JSON) JSON.parse(record.value().toString()),DeleteVo.class);;
                try{
                    System.out.println("删除");
                    String deleteType = deleteVo.getDeleteType();
                    String deleteField = deleteVo.getLogicDeleteField();
                    String deleteFlagValue = deleteVo.getDeleteFlagValue();
                    String idField = deleteVo.getIdField();
                    String idValues = deleteVo.getIdValues();
                    String tableName = deleteVo.getTableName();

                    isConsumered = isConsumeredMessage(deleteVo.getSjkbs(),tableName,idField,deleteVo.getCreatetime());
                    if(isConsumered){
                        acknowledgment.acknowledge();//手动提交偏移量
                        //记录日志
                        saveConsumeredMessageLog(deleteVo.getTableName(),deleteVo.getIdField(),deleteVo.getCreatetime(),
                                deleteVo.getType(),null,"1", String.valueOf(record.offset()));
                        return;
                    }

                    if("LOGIC".equals(deleteType)){//逻辑删除

                        if(deleteVo.isBatch()){
                            jdbcTemplate.update("UPDATE " + tableName + " SET " + deleteField + " = " + deleteFlagValue + " WHERE " + idField + " in( " + idValues + ")");
                        }else {
                            jdbcTemplate.update("UPDATE " + tableName + " SET " + deleteField + " = " + deleteFlagValue + " WHERE " + idField + " = ?", idValues);
                        }
                    }else {//物理删除
                        if(deleteVo.isBatch()){
                            jdbcTemplate.update("DELETE from " + tableName + " where " + idField + " in(" + idValues + ")");
                        }else {
                            jdbcTemplate.update("DELETE from " + tableName + " where " + idField + " = ?", idValues );
                        }
                    }

                    //记录日志
                    saveConsumeredMessageLog(deleteVo.getTableName(),deleteVo.getIdField(),deleteVo.getCreatetime(),
                            deleteVo.getType(),null,"1", String.valueOf(record.offset()));
                    acknowledgment.acknowledge();//手动提交偏移量
                }catch (Exception e){
                    e.printStackTrace();
                    //记录日志
                    saveConsumeredMessageLog(deleteVo.getTableName(),deleteVo.getIdField(),deleteVo.getCreatetime(),
                            deleteVo.getType(),e.toString(),"0", String.valueOf(record.offset()));
                    LOGGER.error("数据保存到数据库过程出错！");
                }

            }
    }

    /**
     * 判断消息是否已经消费过  --  1、是否为本地库推送的消息  2、是否为延迟推送未消费的消息
     * @param editSjkbs 数据库标示
     * @param tableName 表名
     * @param editID    主键id值
     * @param createtime 消息创建时间
     * @return
     */
    boolean isConsumeredMessage(String editSjkbs,String tableName,String editID,String createtime){

        //判断是否为本地库推送的消息
        String localSjkbs = HomepageConfig.getInstance().getValue("XNZM_FBS_SJKBS");
        System.out.println("本地数据库标识:" + localSjkbs);
        if(editSjkbs == null){
            return false;
        }
        if(editSjkbs.equals(localSjkbs)){
            return true;
        }

        //根据消息的创建时间比对本条待消费的记录与已消费记录，若待消费记录消息创建时间早于已消费，则本条记录为延迟推送的记录。不再消费
        String timeCheckSql = "select t.createtime\n" +
                "  from b_jwrq_update_data_log t\n" +
                " where t.status = '1'\n" +
                "   and t.tablename = ?\n" +
                "   and t.val = ?\n" +
                " order by t.createtime DESC";
        List<Map<String,Object>> timeCheckList = jdbcTemplate.queryForList(timeCheckSql,tableName,editID);
        if(timeCheckList.size() > 0){
            Date dealedTimeStr = (Date) timeCheckList.get(0).get("CREATETIME");
            Long dealedTimeTamp = dealedTimeStr.getTime();

            if(dealedTimeTamp > Long.valueOf(createtime)){//待消费记录消息创建时间早于已消费
                return true;
            }
        }
        return false;
    }

    void saveConsumeredMessageLog(String tableName,String idVal,String createTime,String type,String errMsg,
                                  String status,String position){
        String createTimeFmt = sdf.format(new Date(Long.valueOf(createTime)));   // 时间戳转换成时间

        System.out.println("createTimeFmt：" + createTimeFmt);
        String sql = "insert into b_jwrq_update_data_log(SYSTEMID,TABLENAME,VAL,CREATETIME,TYPE,ERRMSG,STATUS,POSITION) " +
                "VALUES(getid(null),?,?,to_date(?,'yyyy/mm/dd HH24:MI:SS'),?,?,?,?)";
        jdbcTemplate.update(sql,tableName,idVal,createTimeFmt,type,errMsg,status,position);
    }

}
