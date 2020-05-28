package com.wykd.jiazhuang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wykd.jiazhuang.dao.RedisDao;


@RestController
@RequestMapping("/jiazhuangService")
public class JiazhuangService {
	
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	@RequestMapping("index")
	public String index() {
		return "微服务【"+serviceName+":" + port +"】欢迎您的访问！" ;
	}
	
	@Autowired
	private RedisDao redisDao;
	
	@RequestMapping("/setValue")
	public String setValue(@RequestParam("key") String key,@RequestParam("value") String value) {
		redisDao.setValue(key, value);
		return "设置成功！";
	}
	
	@RequestMapping("/getValue")
	public String getValue(@RequestParam("key") String key) {
		return redisDao.getValue(key);
	}
	
}
