package com.wykd.user.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wykd.user.bean.UserInfo;


@RestController
@RequestMapping("/tasks")
public class TasksService {
	
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	
	@RequestMapping("index")
	public String index() {
		return "微服务【"+serviceName+":" + port +"】欢迎您的访问！" ;
	}
	
	
	@RequestMapping("/hello")
	public String hello(@RequestParam("hello")String hello) {
		return "微服务【"+hello+"】<br/>&nbsp;&nbsp;&nbsp;&nbsp;访问======>微服务【"+serviceName+":" + port + "】";
	}
	
	@RequestMapping("getUserInfoByUserId")
	public UserInfo getUserInfoByUserId(@RequestParam(value = "userId") long userId) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userId);
		userInfo.setUsername("wangwei");
		userInfo.setAge(30);
		userInfo.setSex("男");
		return userInfo;
	}
	
}
