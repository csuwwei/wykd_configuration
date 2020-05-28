package com.wykd.yundong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/yundongService")
public class YundongService {
	
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	@Autowired
	private MqSender mqSender;
	
	@Autowired
	private MqTopicSender mqTopicSender;
	
	@RequestMapping("index")
	public String index() {
		return "微服务【"+serviceName+":" + port +"】欢迎您的访问！" ;
	}
	
	public String hello() {
		return "hello" ;
	}
	
	@GetMapping("/sendRabbitMQMsg")
	public void sendRabbitMQMsg() {
		for(int i = 1;i<=100 ;i++) {
			mqSender.send(i);
		}
		
	}
	
	/**
	 * 跨微服务，通过rabbitMQ发送消息
	 */
	@GetMapping("/sendMQMsgWithDiffSericeProj")
	public void sendMQMsgWithDiffSericeProj() {
		mqTopicSender.send03();
		
		/*
		yundong微服务打印日志如下：
		发送路由键为key.03的值_start
		发送路由键为key.03的值_end
		监听hello.02队列,绑定的路由键为：key.#===>发送路由键为key.03的值
		
		
		shenghuo微服务打印日志如下：
		监听hello.03队列,绑定的路由键为：key.#===>发送路由键为key.03的值
		
		*/
		
		
	}
	
	
}
