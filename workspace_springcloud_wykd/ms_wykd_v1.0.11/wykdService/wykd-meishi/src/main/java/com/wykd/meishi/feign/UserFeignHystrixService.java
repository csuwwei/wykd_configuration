package com.wykd.meishi.feign;

import org.springframework.stereotype.Component;

import com.wykd.meishi.bean.UserInfo;


@Component
public class UserFeignHystrixService implements IUserFeignService{

	@Override
	public String feignWykdUserHello(String hello) {
		// TODO Auto-generated method stub
		return "feign方式访问微服务【service-wykd-user】异常，触发断路器";
	}

	@Override
	public UserInfo feignGetUserInfoByUserId(long userId) {
		// TODO Auto-generated method stub
		return new UserInfo();
	}


	
	
}
