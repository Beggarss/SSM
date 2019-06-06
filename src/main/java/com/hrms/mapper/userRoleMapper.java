package com.hrms.mapper;

import com.hrms.model.Role;
import com.hrms.model.userRoleKey;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface userRoleMapper {
    int deleteByPrimaryKey(userRoleKey key);

    int insert(userRoleKey record);

    int insertSelective(userRoleKey record);

    List<userRoleKey> getRoles(String userName);
}