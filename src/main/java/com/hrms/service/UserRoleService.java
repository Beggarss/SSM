package com.hrms.service;

import com.hrms.mapper.userRoleMapper;
import com.hrms.model.Role;
import com.hrms.model.userRoleKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleService {
    @Autowired
    userRoleMapper userRoleMapper;
    public List<userRoleKey> getRoles(String userName){
        return userRoleMapper.getRoles(userName);
    }
    public int insertUserAndRole(userRoleKey userRoleKey){
        return  userRoleMapper.insert(userRoleKey);
    }
}
