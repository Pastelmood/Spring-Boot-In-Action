package com.il0v3dorayaki.demo.dao;

import com.il0v3dorayaki.demo.entity.User;

public interface UserDao {

    User findByUserName(String username);

}
