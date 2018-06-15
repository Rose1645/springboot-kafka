package com.rose.kafka.model;

/**
 * Created by liuzhikai on 2018/5/25.
 */
public class DeleteVo {
    public DeleteVo(){
        this.type = "DELETE";
        this.deleteType = "LOGIC";
        this.idField  = "SYSTEMID";
        this.logicDeleteField = "DELETEFLAG";
        this.batch = false;
        this.deleteFlagValue = "1";
    }

    /**
     * 删除的表名
     */
    private String tableName;

    /**
     * 操作类型
     */
    private String type;

    /**
     * LOGIC逻辑删除,默认为逻辑删除 PHYSICAL
     */
    private String deleteType; //删除方式

    /**
     * 表主键 默认为SYSTEMID
     */
    private String idField;


    /**
     * 要删除的主键记录
     */
    private String idValues;


    /**
     * 逻辑删除时，标识字段 默认为DELETEFLAG
     */
    private String logicDeleteField;

    private String sjkbs;//数据库标识

    private String createtime;


    public String getDeleteFlagValue() {
        return deleteFlagValue;
    }

    public void setDeleteFlagValue(String deleteFlagValue) {
        this.deleteFlagValue = deleteFlagValue;
    }

    /**
     * 逻辑删除，标记为删除的值
     */
    private String deleteFlagValue;

    /**
     * 是否批量删除
     */
    private boolean batch;

    public String getDeleteType() {
        return deleteType;
    }

    public void setDeleteType(String deleteType) {
        this.deleteType = deleteType;
    }

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

    public String getIdValues() {
        return idValues;
    }

    public void setIdValues(String idValues) {
        this.idValues = idValues;
    }

    public String getLogicDeleteField() {
        return logicDeleteField;
    }

    public void setLogicDeleteField(String logicDeleteField) {
        this.logicDeleteField = logicDeleteField;
    }

    public boolean isBatch() {
        return batch;
    }

    public void setBatch(boolean batch) {
        this.batch = batch;
    }

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

    public String getSjkbs() {
        return sjkbs;
    }

    public void setSjkbs(String sjkbs) {
        this.sjkbs = sjkbs;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
