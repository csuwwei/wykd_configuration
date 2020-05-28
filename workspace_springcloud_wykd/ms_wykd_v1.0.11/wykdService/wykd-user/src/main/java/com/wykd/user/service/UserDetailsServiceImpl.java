package com.wykd.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wykd.user.bean.UserInfo;
import com.wykd.user.dao.IUserDao;
import com.wykd.user.jwt.JwtUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo user = userDao.findByUsername(s);
        return new JwtUser(user);
    }

}
