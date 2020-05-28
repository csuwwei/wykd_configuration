package com.wykd.meishi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wykd.meishi.bean.UserInfo;
import com.wykd.meishi.feign.IUserFeignService;

@RestController
@RequestMapping("meishiService")
public class MeishiService {

	@Autowired
	private IUserFeignService userFeignService;
	
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	@RequestMapping("index")
	public String index() {
		return "微服务【"+serviceName+":" + port +"】欢迎您的访问！" ;
	}
	
	/**
	 * 使用feign访问service-wykd-user微服务
	 * @return
	 */
	@RequestMapping("/feignWykdUserHello")
	public String feignUserIndex() {
		String result = userFeignService.feignWykdUserHello(serviceName +":"+ port);
		return result;
	}
	
	/**
	 * 使用feign访问service-wykd-user微服务
	 * 		传递用户ID参数，获取用户信息
	 * @return
	 */
	@RequestMapping("/feignUserInfoByUserId")
	public UserInfo getUserInfoById(@RequestParam(value = "userId") long userId) {
		UserInfo userInfo = userFeignService.feignGetUserInfoByUserId(userId);
		return userInfo;
	}
	
}
