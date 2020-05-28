package com.wykd.nacos.service.fallback;

import org.springframework.stereotype.Component;

import com.wykd.nacos.service.NocosConsumerService;
import com.wykd.nacos.service.feign.NocosConsumerFeignService;

@Component
public class NocosConsumerFallbackService implements NocosConsumerFeignService{

	@Override
	public String hello() {
		return "服务异常！";
	}


}
