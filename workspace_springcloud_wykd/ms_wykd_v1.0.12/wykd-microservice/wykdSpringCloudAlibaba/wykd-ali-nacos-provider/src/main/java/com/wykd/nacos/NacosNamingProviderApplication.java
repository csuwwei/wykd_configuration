package com.wykd.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosNamingProviderApplication {

	public static void main(String[] args) {
		System.setProperty("nacos.standalone", "true");
		SpringApplication.run(NacosNamingProviderApplication.class, args);
	}

}
