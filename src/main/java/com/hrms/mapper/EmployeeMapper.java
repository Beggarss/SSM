package com.hrms.mapper;

import com.hrms.model.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(@Param("empId") Integer empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Employee selectByIdAndPassWord( Integer id, Integer passWord);

    int updatePassWord(@Param("empId") Integer id,@Param("empPassword") String password,@Param("empEmail") String email);

    List<Employee> selectAllEmployee();
}