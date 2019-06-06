package com.hrms.mapper;

import com.hrms.model.RolePermissionKey;

import java.util.List;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(RolePermissionKey key);

    int insert(RolePermissionKey record);

    int insertSelective(RolePermissionKey record);

    List<RolePermissionKey> getPermissions(Integer roleId);
}