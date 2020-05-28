package com.wykd.yundong.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqTopicReceiver {

	@RabbitListener(queues = "hello.01")  //监听hello.01队列,绑定的路由键为：key.01
	public void receiveHello01(String hello) {
		System.out.println("监听hello.01队列,绑定的路由键为：key.01===>"+hello);
	}
	
	@RabbitListener(queues = "hello.02")  //监听hello.02队列,绑定的路由键为：key.#
	public void receiveHello02(String hello) {
		System.out.println("监听hello.02队列,绑定的路由键为：key.#===>"+hello);
	}
	
	
}
