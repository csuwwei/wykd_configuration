package com.wykd.nacos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wykd.nacos.service.NocosConsumerService;
import com.wykd.nacos.service.feign.NocosConsumerFeignService;

@Service
public class NocosConsumerServiceImpl implements NocosConsumerService{

	@Autowired
	private NocosConsumerFeignService nocosConsumerFeignService;
	
	
	public String feignNocosRegisterTest() {
		return nocosConsumerFeignService.hello();
	}
	
}
