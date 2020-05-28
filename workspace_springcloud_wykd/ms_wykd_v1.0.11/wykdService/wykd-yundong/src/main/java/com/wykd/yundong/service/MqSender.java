package com.wykd.yundong.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		this.rabbitTemplate.convertAndSend("hello", "this is a rabbitMQ message!" );
	}
	
	public void send(int i) {
		this.rabbitTemplate.convertAndSend("hello", "===>"+ String.valueOf(i));
	}

}
