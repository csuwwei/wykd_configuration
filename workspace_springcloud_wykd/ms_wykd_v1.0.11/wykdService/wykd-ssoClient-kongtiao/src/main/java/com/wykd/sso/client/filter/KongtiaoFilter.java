package com.wykd.sso.client.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class KongtiaoFilter implements Filter{

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//1.判断是否登录
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		if(isLogin != null && isLogin) {
			//已登录，则放行
			chain.doFilter(request, response);
			return;
		}else {
			String token = (String) request.getParameter("token");
			if(!StringUtils.isEmpty(token)) {
				
				//验证已经存在token
				
				String url = "http://localhost:9021/wykd-jiadian/jiadianRedirectService/validToken?token=" +token;
				
				ResponseEntity entity = new RestTemplate().getForEntity(url, Boolean.class,"" );
				Boolean body = (Boolean) entity.getBody();
				if(body != null && body) {
					session.setAttribute("isLogin", true);
					chain.doFilter(request, response);
					return;
				}
			}
			
			//未登录，则重定向到ssoServer的登录页面
			String url = "http://localhost:9021/wykd-jiadian/jiadianRedirectService/validPerm";
			url += "?redirectUrl=http://localhost:9022/wykd-kongtiao/kongtiaoRedirectService/main";
			resp.sendRedirect(url);
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
