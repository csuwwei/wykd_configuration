package com.wykd.sso.client.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("kongtiaoRedirectService")
public class KongtiaoRedirectService {

	@GetMapping("index")
	public String index(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.setAttribute("isLogin", true);
		return "/index.html";
	}
	
	
	@GetMapping("main")
	public String main(HttpServletRequest request) {
		
		
		
		return "/main.html";
	}
	
}
