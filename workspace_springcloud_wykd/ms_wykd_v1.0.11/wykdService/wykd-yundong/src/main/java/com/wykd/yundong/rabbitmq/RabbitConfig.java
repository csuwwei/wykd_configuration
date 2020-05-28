package com.wykd.yundong.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

@Configuration
public class RabbitConfig {
	
	//############################  最简单的rabbitMQ例子
	
	@Bean
	public Queue Queue() {
		return new Queue("hello");
	}
	
	//############################  topic方式的rabbitMQ例子
	
	@Bean
	public Queue queueMessages01() {
		return new Queue("hello.01");
	}
	
	@Bean
	public Queue queueMessages02() {
		return new Queue("hello.02");
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("topicExchange");
	}
	
	@Bean
	public Binding bingingExchange01() {
		//将队列，通过key.01绑定到路由
		return BindingBuilder.bind(queueMessages01()).to(topicExchange()).with("key.01");
	}
	
	@Bean
	public Binding bingingExchange02() {
		//将队列，通过key.#绑定到路由
		return BindingBuilder.bind(queueMessages02()).to(topicExchange()).with("key.#");
	}
	
	@Bean
	public Queue queueMessages03() {
		return new Queue("hello.03");
	}
	
	@Bean
	public Binding bingingExchange03() {
		//将队列，通过key.03绑定到路由
		return BindingBuilder.bind(queueMessages03()).to(topicExchange()).with("key.03");
	}
}
