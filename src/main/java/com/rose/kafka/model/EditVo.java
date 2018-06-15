package com.rose.kafka.model;

/**
 * Created by liuzhikai on 2018/5/24.
 */
public class EditVo {
    private String tableName;
    private String type;
    private String dataStr;
    private String idVal;//记录主键值
    private String createtime;
    private String sjkbs;//数据库标识

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    public String getIdVal() {
        return idVal;
    }

    public void setIdVal(String idVal) {
        this.idVal = idVal;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getSjkbs() {
        return sjkbs;
    }

    public void setSjkbs(String sjkbs) {
        this.sjkbs = sjkbs;
    }
}
