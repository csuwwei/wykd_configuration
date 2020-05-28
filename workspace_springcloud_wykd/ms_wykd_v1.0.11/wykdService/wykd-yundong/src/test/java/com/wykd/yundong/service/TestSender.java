package com.wykd.yundong.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wykd.yundong.bean.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSender {

	@Autowired
	private YundongService yundongService;
	
	@Autowired
	private MqSender mqSender;
	
	@Autowired
	private MqSender2 mqSender2;
	
	@Autowired
	private MqSendUser mqSendUser;
	
	
	@Test
	public void test01() {
		System.out.println(yundongService.hello());
	}
	
	@Test
	public void test02() {
		mqSender.send();
	}
	
	@Test
	public void test03() {
		for(int i = 1;i<=20 ;i++) {
			mqSender.send(i);
		}
	}
	
	@Test
	public void test04() {
		for(int i = 1;i<=20 ;i++) {
			mqSender.send(i);
			mqSender2.send(i);
		}
	}
	
	
	@Test
	public void test05() {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setAge(100);
		userInfo.setUserName("老王");
		mqSendUser.send(userInfo);
	}
	
	@Autowired
	private MqTopicSender mqTopicSender;
	
	@Test
	public void test06() {
		mqTopicSender.send01();
		
//		发送路由键为key.01的值_start
//		发送路由键为key.01的值_end
//		监听hello.01队列,绑定的路由键为：key.01===>发送路由键为key.01的值
//		监听hello.02队列,绑定的路由键为：key.#===>发送路由键为key.01的值
		
//		结论：消息发送了一个【key.01】路由键的消息，被hello.01，以及hello.02监听到。
		
	}
	
	@Test
	public void test07() {
		mqTopicSender.send02();
		
//		发送路由键为key.02的值_start
//		发送路由键为key.02的值_end
//		监听hello.02队列,绑定的路由键为：key.#===>发送路由键为key.02的值
		
//		结论：消息发送了一个【key.02】路由键的消息，只被hello.02监听到。
		
	}
	
	@Test
	public void test08() {
		mqTopicSender.send03();
	}
}
