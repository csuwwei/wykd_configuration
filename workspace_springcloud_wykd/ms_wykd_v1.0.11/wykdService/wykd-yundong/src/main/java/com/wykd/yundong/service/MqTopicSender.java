package com.wykd.yundong.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqTopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send01() {
		System.out.println("发送路由键为key.01的值_start");
		this.rabbitTemplate.convertAndSend("topicExchange", "key.01", "发送路由键为key.01的值");
		System.out.println("发送路由键为key.01的值_end");
	}
	
	public void send02() {
		System.out.println("发送路由键为key.02的值_start");
		this.rabbitTemplate.convertAndSend("topicExchange", "key.02", "发送路由键为key.02的值");
		System.out.println("发送路由键为key.02的值_end");
	}

	public void send03() {
		System.out.println("发送路由键为key.03的值_start");
		this.rabbitTemplate.convertAndSend("topicExchange", "key.03", "发送路由键为key.03的值");
		System.out.println("发送路由键为key.03的值_end");
	}

}
