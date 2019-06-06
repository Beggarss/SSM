package com.hrms.service;

import com.hrms.mapper.PermissionMapper;
import com.hrms.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    public List<Permission> getPermissions(Integer id){
        return permissionMapper.selectByPrimaryKey(id);
    }
}
