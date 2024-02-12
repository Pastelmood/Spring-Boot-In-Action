package com.il0v3dorayaki.demo.service;

import com.il0v3dorayaki.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

}
