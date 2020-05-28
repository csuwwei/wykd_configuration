package com.wykd.yundong.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.wykd.yundong.bean.UserInfo;

@Component
@RabbitListener(queues = "hello")
public class MqReceiveUser {

	@RabbitHandler
	public void receive(UserInfo userInfo) {
		System.out.println(JSON.toJSONString(userInfo));
	}
	
	
}
