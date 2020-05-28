package com.wykd.meishi.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wykd.meishi.bean.UserInfo;
import com.wykd.meishi.feign.IUserFeignService;

/**
 * 	多线程编程
 * 		Runnable
 * 		Callable
 * 		线程池
 * @author Alex
 *
 */
@RestController
@RequestMapping("/meishiThreadService")
public class MeishiThreadService {

	@Autowired
	private IUserFeignService userFeignService;
	
	ExecutorService executorService = Executors.newFixedThreadPool(2);
	
	
	@RequestMapping("/feignWykdUser")
	public Map feignWykdUser() {
		
		long start = System.currentTimeMillis();
		Map returnMap = new HashMap();
		UserInfo result1 = userFeignService.feignGetUserInfoByUserId(100L);
		returnMap.put("userInfo", result1);
		String result2 = userFeignService.feignWykdUserHello("hello");
		returnMap.put("helloInfo", result2);
		
		long end = System.currentTimeMillis();
		System.out.println("总执行时间："+(end-start));
		
		returnMap.put("time", end-start);
		return returnMap;
	}
	
	@RequestMapping("/feignWykdUserThread")
	public Map feignWykdUserThread() {
		
		long start = System.currentTimeMillis();
		Map returnMap = new HashMap();
		
		Callable<UserInfo> userInfoCall = new Callable<UserInfo>() {
			@Override
			public UserInfo call() throws Exception {
				long start = System.currentTimeMillis();
				UserInfo result = userFeignService.feignGetUserInfoByUserId(100L);
				long end = System.currentTimeMillis();
				System.out.println("userInfoCallCall执行时间："+(end-start));
				return result;
			}
		};
		
		Callable<String> helloInfoCall = new Callable<String>() {
			@Override
			public String call() throws Exception {
				long start = System.currentTimeMillis();
				String result = userFeignService.feignWykdUserHello("hello");
				long end = System.currentTimeMillis();
				System.out.println("helloInfoCall执行时间："+(end-start));
				return result;
			}
		};
		
		FutureTask<String> helloInfo = new FutureTask<>(helloInfoCall);
		FutureTask<UserInfo> userInfo = new FutureTask<>(userInfoCall);
		
		new Thread(helloInfo).start();
		new Thread(userInfo).start();
		
		
		try {
			returnMap.put("helloInfo", helloInfo.get());
			returnMap.put("userInfo", userInfo.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("总执行时间："+(end-start));
		returnMap.put("time", end-start);
		return returnMap;
	}
	
	@RequestMapping("/feignWykdUserThreadPool")
	public Map feignWykdUserThreadPool() {
		long start = System.currentTimeMillis();
		Map returnMap = new HashMap();
		
		Callable<UserInfo> userInfoCall = new Callable<UserInfo>() {
			@Override
			public UserInfo call() throws Exception {
				long start = System.currentTimeMillis();
				UserInfo result = userFeignService.feignGetUserInfoByUserId(100L);
				long end = System.currentTimeMillis();
				System.out.println("userInfoCallCall执行时间："+(end-start));
				return result;
			}
		};
		
		Callable<String> helloInfoCall = new Callable<String>() {
			@Override
			public String call() throws Exception {
				long start = System.currentTimeMillis();
				String result = userFeignService.feignWykdUserHello("hello");
				long end = System.currentTimeMillis();
				System.out.println("helloInfoCall执行时间："+(end-start));
				return result;
			}
		};
		
		FutureTask<String> helloInfo = new FutureTask<>(helloInfoCall);
		FutureTask<UserInfo> userInfo = new FutureTask<>(userInfoCall);
		
		executorService.submit(helloInfo);
		executorService.submit(userInfo);
		
		try {
			returnMap.put("helloInfo", helloInfo.get());
			returnMap.put("userInfo", userInfo.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("总共执行时间："+(end-start));
		returnMap.put("time", end-start);
		return returnMap;
	}
	
	
}
