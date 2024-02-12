package com.il0v3dorayaki.demo.dao;

import com.il0v3dorayaki.demo.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String theRoleName);

}
