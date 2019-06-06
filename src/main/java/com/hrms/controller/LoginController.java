package com.hrms.controller;

import com.hrms.model.Employee;
import com.hrms.service.EmployeeService;
import com.hrms.util.Encrpty;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
    public ModelAndView doLogin(@RequestParam(value = "id",required = false) String id,@RequestParam("password") String passWord, HttpServletRequest httpServletRequest) throws IOException, NoSuchAlgorithmException {
        ModelAndView mv;
        if (id == null) {
            httpServletRequest.setAttribute("id_message", "员工号不能为空！");
        }
        if (passWord == null) {
            httpServletRequest.setAttribute("password_message", "密码不能为空！");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(id, passWord);
        Subject subject = SecurityUtils.getSubject();
         try {
            subject.login(token);
         }catch(UnknownAccountException uae){
             System.out.println("对用户[" + id + "]进行登录验证...验证未通过，未知账户");
             httpServletRequest.setAttribute("message_login", "未知账户");
         }catch(IncorrectCredentialsException ice){
             System.out.println("对用户[" + id + "]进行登录验证...验证未通过，错误的凭证");
             httpServletRequest.setAttribute("message_login", "密码不正确");
         }catch(LockedAccountException lae){
             System.out.println("对用户[" + id + "]进行登录验证...验证未通过，账户已锁定");
             httpServletRequest.setAttribute("message_login", "账户已锁定");
         }catch(ExcessiveAttemptsException eae){
             System.out.println("对用户[" + id + "]进行登录验证...验证未通过，错误次数过多");
             httpServletRequest.setAttribute("message_login", "用户名或密码错误次数过多");
         }catch(AuthenticationException ae){
             //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
             System.out.println("对用户[" + id + "]进行登录验证...验证未通过，堆栈轨迹如下");
             ae.printStackTrace();
             httpServletRequest.setAttribute("message_login", "用户名或密码不正确");
         }
        if (subject.isAuthenticated()) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("employee", id);
            return new ModelAndView("punch");
        } else {
            token.clear();
            httpServletRequest.setAttribute("MSG", "用户名或密码错误！");
            return new ModelAndView("login");
            //return  new ModelAndView("punch");

//        //验证密码
//
//        Employee employee1=employeeService.selectByPrimaryKey(id);
//        if(employee1!=null){
//            if(Encrpty.checkPassword(passWord,employee1.getEmpPassword())){
//                HttpSession session=httpServletRequest.getSession();
//                session.setAttribute("employee",id);
//                return new ModelAndView("punch");
//            }else{
//                httpServletRequest.setAttribute("MSG","用户名或密码错误！");
//                return new ModelAndView("login");
//            }
//
//        }else{
//            httpServletRequest.setAttribute("MSG","用户名或密码错误！");
//            return new ModelAndView("login");
//        }
//            return new ModelAndView();
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
    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }






}
