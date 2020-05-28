package com.wykd.yundong.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wykd.yundong.bean.UserInfo;

@Component
public class MqSendUser {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(UserInfo userInfo) {
		this.rabbitTemplate.convertAndSend("hello", userInfo);
	}
	

}
