package com.wykd.yundong.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class MqReceiver {

	@RabbitHandler
	public void receive(String hello) {
		System.out.println(this.getClass().getName()+"===>"+hello);
	}
	
	
}
