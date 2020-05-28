package com.wykd.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.unicon.cas.client.configuration.EnableCasClient;

@SpringBootApplication
@EnableCasClient
public class BingxiangApplication {

	public static void main(String[] args) {
		SpringApplication.run(BingxiangApplication.class, args);
	}

}
