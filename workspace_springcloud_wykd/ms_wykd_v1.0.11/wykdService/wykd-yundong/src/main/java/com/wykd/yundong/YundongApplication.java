package com.wykd.yundong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YundongApplication {

	public static void main(String[] args) {
		SpringApplication.run(YundongApplication.class, args);
	}

}
