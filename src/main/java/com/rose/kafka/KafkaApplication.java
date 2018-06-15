package com.rose.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication
//忽略springboot默认的kafka配置，删除项目启动会报错。没有提供默认配置中的相关Bean
@EnableAutoConfiguration(exclude = KafkaAutoConfiguration.class)
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}
}
