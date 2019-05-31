package com.hrms.controller;

import com.hrms.model.Attendence;
import com.hrms.model.Employee;
import com.hrms.service.AttendenceService;
import com.hrms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author GenshenWang.nomico
 * @date 2018/3/2.
 */
@Controller
public class TestController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    AttendenceService attendenceService;
    @RequestMapping(value = "/test",  method = RequestMethod.GET)
    public String index(HttpServletRequest httpServletRequest){
        String s ="E:\\web工作区间\\人力资源管理系统\\src\\main\\webapp\\resource\\upload\\201905261238_简历照片.jpg";

       // String s="E:\\web工作区间\\人力资源管理系统\\target\\SSM_HRMS\\upload\\201905261152_简历照片.jpg";
       // System.out.println(s);
        httpServletRequest.setAttribute("s",s);
        return  "test";
    }
}
