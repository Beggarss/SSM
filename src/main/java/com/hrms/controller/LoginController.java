package com.hrms.controller;

import com.hrms.model.Employee;
import com.hrms.service.EmployeeService;
import com.hrms.util.Encrpty;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping(value = "/hrms")
public class LoginController {
    @Autowired
    EmployeeService employeeService;
    /**
     * 登录：跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 对登录页面输入的用户名和密码做简单的判断
     * @param id @param passwrod
     * @return
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView doLogin(@RequestParam(value = "id",required = false) Integer id,@RequestParam("password") String passWord, HttpServletRequest httpServletRequest) throws IOException, NoSuchAlgorithmException {
        ModelAndView mv ;
        if(id==null){
            httpServletRequest.setAttribute("id","员工号不能为空！");
        }
        if(passWord==null){
            httpServletRequest.setAttribute("password","密码不能为空！");
        }
        //验证密码

        Employee employee1=employeeService.selectByPrimaryKey(id);
        if(employee1!=null){
            if(Encrpty.checkPassword(passWord,employee1.getEmpPassword())){
                HttpSession session=httpServletRequest.getSession();
                session.setAttribute("employee",id);
                return new ModelAndView("punch");
            }else{
                httpServletRequest.setAttribute("MSG","用户名或密码错误！");
                return new ModelAndView("login");
            }

        }else{
            httpServletRequest.setAttribute("MSG","用户名或密码错误！");
            return new ModelAndView("login");
        }
    }
    /**
     * 跳转到主页面
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(){
        return "main";
    }

    /**
     * 退出登录：从主页面跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
        HttpSession session =httpServletRequest.getSession();
        session.invalidate();
        return "login";
    }






}
