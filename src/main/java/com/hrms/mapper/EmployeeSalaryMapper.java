package com.hrms.mapper;

import com.hrms.model.EmployeeSalary;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeSalaryMapper {
    int deleteByPrimaryKey(String empPositiom);

    int insert(EmployeeSalary record);

    int insertSelective(EmployeeSalary record);

    EmployeeSalary selectByPrimaryKey(String empPositiom);

    int updateByPrimaryKeySelective(EmployeeSalary record);

    int updateByPrimaryKey(int id,int password);
}