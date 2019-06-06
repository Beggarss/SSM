package com.hrms.service;

import com.hrms.mapper.RoleMapper;
import com.hrms.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    public Role getRoles(String userName){
        return roleMapper.getRoles(userName);
    }
}
