package com.ntreddy.dd.ecommerce.service;

import com.ntreddy.dd.ecommerce.entity.Role;

public interface RoleService {
    Role findByName(String name);
}
