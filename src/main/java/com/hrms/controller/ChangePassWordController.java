package com.hrms.controller;

import  com.hrms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import  com.hrms.util.Encrpty;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/hrms")
public class ChangePassWordController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/changePassWord")
    public ModelAndView changePassWord(@RequestParam("id") Integer id,@RequestParam("email") String email,@RequestParam("passWord") String passWord,HttpServletRequest httpServletRequest) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ModelAndView mv ;
        if(id==null){
            httpServletRequest.setAttribute("id","员工号不能为空！");
        }
        if(passWord==null){
            httpServletRequest.setAttribute("password","密码不能为空！");
        }
        if(!email.matches("^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$")){
            httpServletRequest.setAttribute("email","邮箱格式为空!");
        }
        //将密码通过md5算法加密存入数据库中
        String dbPwd=Encrpty.encrptyPassword(passWord);
        int result=employeeService.updatePassWord(id,dbPwd,email);
        if(result>0){
            mv=new ModelAndView("validation");
            return mv;
        }else{
            httpServletRequest.setAttribute("message","id与邮箱不匹配");
            return new ModelAndView("doChangePassWord");
        }

    }
    @RequestMapping("/doChangePassWord")
    public ModelAndView doChangePassWord(){
        ModelAndView mv =new ModelAndView("changePassWord");
        return mv;
    }

}
