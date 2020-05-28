package com.wykd.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wykd.nacos.service.NocosConsumerService;

@RestController
public class NocosConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private NocosConsumerService nocosConsumerServiceImpl;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "nocos consumer hello world";
	}
	
	@GetMapping("/nocosRegisterTest")
	public String nocosRegisterTest() {
		
		ServiceInstance instance = loadBalancerClient.choose("service-wykd-nocos-provider");
		String ip = instance.getHost();
		int port = instance.getPort();
		
		String returnValue = restTemplate.getForObject("http://"+ip+":"+port+"/wykd-nacos-provider/hello", String.class);
		
		return returnValue;
	}
	
	@GetMapping("/feignNocosRegisterTest")
	public String feignNocosRegisterTest() {
		
		return nocosConsumerServiceImpl.feignNocosRegisterTest();
	}
	
}
