package com.ntreddy.dd.ecommerce.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntreddy.dd.ecommerce.entity.Role;
import com.ntreddy.dd.ecommerce.repository.RoleDao;
import com.ntreddy.dd.ecommerce.service.RoleService;



@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}
