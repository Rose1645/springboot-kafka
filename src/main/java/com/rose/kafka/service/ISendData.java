package com.rose.kafka.service;


import com.rose.kafka.model.DeleteVo;
import com.rose.kafka.model.EditVo;

/**
 * Created by liuzhikai on 2018/5/25.
 */
public interface ISendData {
    public String delete(DeleteVo deleteVo);
    public String edit(EditVo editVo);
}
