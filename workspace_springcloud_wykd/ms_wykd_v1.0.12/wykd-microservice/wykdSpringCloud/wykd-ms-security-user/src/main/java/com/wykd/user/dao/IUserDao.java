package com.wykd.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wykd.user.bean.UserInfo;

@Mapper
public interface IUserDao {

	@Insert("insert into sec_user(userName,password) values(#{userName},#{password})")
	int add(@Param("userName")String userName,@Param("password")String password);
	
	@Insert("insert into sec_user(userName,password,role) values(#{userName},#{password},#{role})")
	int insertUser(@Param("userName")String userName,@Param("password")String password,@Param("role")String role);
	
	@Select("select * from sec_user")
	List<UserInfo> getUserList();
	
	@Select("select * from sec_user where userName = #{userName}")
	UserInfo findByUsername(@Param("userName")String userName);
}
