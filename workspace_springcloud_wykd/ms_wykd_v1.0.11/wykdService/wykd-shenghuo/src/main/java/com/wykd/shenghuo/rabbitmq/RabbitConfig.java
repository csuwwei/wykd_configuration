package com.wykd.shenghuo.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

@Configuration
public class RabbitConfig {
	
	
	@Bean
	public Queue queueMessages02() {
		return new Queue("hello.03");
	}
	
	
}
