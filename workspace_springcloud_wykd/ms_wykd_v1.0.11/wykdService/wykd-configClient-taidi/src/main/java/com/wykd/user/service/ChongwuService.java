package com.wykd.user.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wykd.user.bean.UserInfo;


@RestController
@RequestMapping("/chongwuService")
public class ChongwuService {
	
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	@RequestMapping("index")
	public String index() {
		return "微服务【"+serviceName+":" + port +"】欢迎您的访问！" ;
	}
	
	@Value("${foo}")
	private String foo;
	
	@RequestMapping("/hello")
	public String config() {
		return foo;
	}
	
	
	
}
