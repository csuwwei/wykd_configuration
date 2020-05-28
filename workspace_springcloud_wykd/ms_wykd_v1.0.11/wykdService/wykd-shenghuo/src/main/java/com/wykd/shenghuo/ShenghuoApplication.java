package com.wykd.shenghuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShenghuoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShenghuoApplication.class, args);
	}

}
