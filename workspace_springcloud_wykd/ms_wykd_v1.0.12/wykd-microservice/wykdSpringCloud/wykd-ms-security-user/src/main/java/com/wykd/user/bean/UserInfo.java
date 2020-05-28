package com.wykd.user.bean;

import java.io.Serializable;

public class UserInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	long userId;
	private String username;
	private String password;
	private int age;
	private String sex;
	
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + username + ", password=" + password + ", age=" + age
				+ ", sex=" + sex + ", role=" + role + "]";
	}
	
	
	
	
}
