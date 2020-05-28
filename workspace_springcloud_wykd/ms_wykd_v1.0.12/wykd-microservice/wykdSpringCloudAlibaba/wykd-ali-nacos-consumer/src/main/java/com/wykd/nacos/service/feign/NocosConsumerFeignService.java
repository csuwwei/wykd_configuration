package com.wykd.nacos.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.wykd.nacos.service.fallback.NocosConsumerFallbackService;


@FeignClient(value="service-wykd-nocos-provider",fallback=NocosConsumerFallbackService.class)
public interface NocosConsumerFeignService {

	@GetMapping("/wykd-nacos-provider/hello")
	public String hello() ;
	
}
