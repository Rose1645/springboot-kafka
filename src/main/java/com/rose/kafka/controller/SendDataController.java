package com.rose.kafka.controller;

import com.rose.kafka.model.DeleteVo;
import com.rose.kafka.model.EditVo;
import com.rose.kafka.service.ISendData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sendData")
public class SendDataController {

    @Autowired
    private ISendData iSendData;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/sendMessageTest", method = RequestMethod.GET)
    public String sendMessageTest(String message){
        kafkaTemplate.send("kafkaTest",message);
        return "success";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String send(@RequestBody EditVo editVo){
        EditVo vo = editVo;
        iSendData.edit(editVo);
        return "edit";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody DeleteVo deleteVo){
        DeleteVo vo = deleteVo;
        iSendData.delete(deleteVo);
        return "delete";
    }
}
