package com.wykd.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/movieService")
public class MovieService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	@RequestMapping("index")
	public String index() {
		return "微服务【"+serviceName+":" + port +"】欢迎您的访问！" ;
	}
	
	@RequestMapping("/restWykdUserHello")
	@HystrixCommand(fallbackMethod="helloError")
	public String restUserInfo() {
//		String url = "http://localhost:8003/wykd-user/index";
		
		String url = "http://SERVICE-WYKD-USER/wykd-user/userService/hello?hello=" +serviceName+":" + port;
		
		ResponseEntity entity = this.restTemplate.getForEntity(url, String.class,"" );
		String body = (String) entity.getBody();
		System.out.println(JSON.toJSONString(entity));
		return body;
	}
	
	public String helloError() {
		String result = "ribbon访问微服务【SERVICE-WYKD-USER】异常，触发断路器！";
		return result;
	}
	
}
