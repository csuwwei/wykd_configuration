package com.wykd.meishi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wykd.meishi.bean.UserInfo;



@FeignClient(value ="service-wykd-user",fallback = UserFeignHystrixService.class)
public interface IUserFeignService {


	@RequestMapping(value = "/wykd-user/userService/hello",method = RequestMethod.GET)
	public String feignWykdUserHello(@RequestParam(value = "hello") String hello);
	
	
	@RequestMapping(value = "/wykd-user/userService/getUserInfoByUserId",method = RequestMethod.GET)
	public UserInfo feignGetUserInfoByUserId(@RequestParam(value = "userId") long userId) ;

	
	
}
