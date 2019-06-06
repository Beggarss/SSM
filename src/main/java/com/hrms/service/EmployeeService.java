package com.hrms.service;

import com.hrms.mapper.EmployeeMapper;
import com.hrms.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  EmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;
    public Employee selectByPrimaryKey(String id){
        return employeeMapper.selectByPrimaryKey(id);
    }
    public int updatePassWord(String id,String password,String email){
        return employeeMapper.updatePassWord(id,password,email);
    }
    public List<Employee> selectAllEmployee(){
        return employeeMapper.selectAllEmployee();
    }
    public int insert(Employee employee){
        return employeeMapper.insert(employee);
    }
}