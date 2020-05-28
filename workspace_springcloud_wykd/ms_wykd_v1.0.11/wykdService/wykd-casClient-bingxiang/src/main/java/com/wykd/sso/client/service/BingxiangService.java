package com.wykd.sso.client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bingxiangService")
public class BingxiangService {

	@Value("${server.port}")
	private String port;
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	
	@RequestMapping("index")
	public String index() {
		return "微服务【"+serviceName+":" + port +"】欢迎您的访问！" ;
	}
	

	@RequestMapping("hello")
	public String hello() {
		return "微服务【"+serviceName+":" + port +"】欢迎您的访问！" ;
	}
}
