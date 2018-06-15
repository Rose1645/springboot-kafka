package com.rose.kafka.service;

import com.rose.kafka.model.B_JWRQ_APPMENU;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by liuzhikai on 2018/5/23.
 */
@Service(value = "B_JWRQ_APPMENURepository")
public interface B_JWRQ_APPMENURepository extends CrudRepository<B_JWRQ_APPMENU, String> {

}
