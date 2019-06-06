package com.hrms.service;
import com.hrms.mapper.RolePermissionMapper;
import com.hrms.model.RolePermissionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RolePermissionService {
    @Autowired
    RolePermissionMapper rolePermissionMapper;
    public List<RolePermissionKey> getPermissions(Integer roleId){
        return  rolePermissionMapper.getPermissions(roleId);
    }
}
