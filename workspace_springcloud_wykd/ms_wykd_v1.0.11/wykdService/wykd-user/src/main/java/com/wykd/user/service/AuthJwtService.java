package com.wykd.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wykd.user.bean.UserInfo;
import com.wykd.user.dao.IUserDao;

@RestController
@RequestMapping("/auth")
public class AuthJwtService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private IUserDao userDao;
	  
	@PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        UserInfo user = new UserInfo();
        String userName = registerUser.get("username");
        // 记得注册的时候把密码加密一下
        String password = bCryptPasswordEncoder.encode(registerUser.get("password"));
//        user.setRole("ROLE_USER");
        userDao.insertUser(userName, password,"administrator");
        
//        user.setUserName(userName);
//        user.setPassword(password);
        
        user = userDao.findByUsername(userName);
        
        return user.toString();
    }
	
}
