package com.wykd.sso.server.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wykd.sso.server.service.bo.UserInfo;

@Controller
@RequestMapping("/jiadianRedirectService")
public class JiadianRedirectService {

	private List tokenList = new ArrayList();
	
	
	@RequestMapping("validPerm")
	public String validPerm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String redirectUrl = request.getParameter("redirectUrl");
		
		String token = (String) session.getAttribute("token");
		if(token != null && !token.isEmpty()) {
			//token不为空，则说明已经有全局回话，可以不用登录
			return "redirect:" + redirectUrl + "?token="+token.toString();
		}
		
		request.setAttribute("redirectUrl", redirectUrl);
		
		return "login";
	}
	
	

	@GetMapping("index")
	public String index(UserInfo userInfo) {
		
		
		
		return "/index.html";
	}
	
	@PostMapping("login")
	public void login(UserInfo userInfo,HttpServletRequest request,HttpServletResponse response) {
		try {
			if(userInfo.getPassword().equals("666")
					&& userInfo.getUsername().equals("老王")) {
				String url = request.getParameter("redirectUrl");
				
					UUID token = UUID.randomUUID();
					tokenList.add(token.toString());
					request.getSession().setAttribute("token", token.toString());
					response.sendRedirect(url + "?token="+token.toString());
			}else {
				validPerm(request);
			}
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	@RequestMapping("/validToken")
	@ResponseBody
	public Boolean validToken(@RequestParam("token") String token) {
		if(tokenList.contains(token)) {
			return true;
		}
		return false;
	}
	
}
