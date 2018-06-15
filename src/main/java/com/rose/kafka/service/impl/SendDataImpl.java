package com.rose.kafka.service.impl;

import com.alibaba.fastjson.JSON;
import com.rose.kafka.model.DeleteVo;
import com.rose.kafka.model.EditVo;
import com.rose.kafka.service.ISendData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by liuzhikai on 2018/5/25.
 */
@Service
public class SendDataImpl implements ISendData {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public String delete(DeleteVo deleteVo) {
        String dataStr = JSON.toJSONString(deleteVo);
        kafkaTemplate.send("xnzmTables",dataStr);
        return null;
    }

    @Override
    public String edit(EditVo editVo) {
        String dataStr = JSON.toJSONString(editVo);
        kafkaTemplate.send("xnzmTables",dataStr);
        return null;
    }
}
