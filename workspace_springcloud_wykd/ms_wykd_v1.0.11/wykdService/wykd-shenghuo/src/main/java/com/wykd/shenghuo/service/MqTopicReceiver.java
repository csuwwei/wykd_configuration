package com.wykd.shenghuo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqTopicReceiver {

	@RabbitListener(queues = "hello.03")  //监听hello.03队列,绑定的路由键为：key.03
	public void receiveHello02(String hello) {
		System.out.println("监听hello.03队列,绑定的路由键为：key.03===>"+hello);
	}
	
	
}
