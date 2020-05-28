package com.wykd.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wykd.user.bean.UserInfo;
import com.wykd.user.dao.IUserDao;


@RestController
@RequestMapping("/testMybatisService")
public class TestMybatisService {
	
	@Autowired
	private IUserDao userDao;
	
	@RequestMapping("addUser")
	public List addUser() {
		
		int randomNum = (int)(Math.random() * 100 );
		userDao.add("wangwei"+ randomNum, randomNum+ "");
		List userList = userDao.getUserList();
		return userList;
	}
	
	
	/**
	 * 声明式注解实现事务
	 * @return
	 */
	@RequestMapping("testTransactional")
	@Transactional
	public String testTransactional() {
		
		userDao.add("wangwei11", "abv");
		int i = 1/0;
		userDao.add("wangwei13", "ddd");
		
		return "添加成功！";
	}
	
	
}
