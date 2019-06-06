package com.hrms.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class managerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session =httpServletRequest.getSession();
        if(session.getAttribute("manager")!=null){
            return true;
        }else{
          //  httpServletRequest.getRequestDispatcher("/administrator/managerLogin.do").forward(httpServletRequest,httpServletResponse);
            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.getWriter().print("<script>alert('无权限！');history.back();</script>");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        super.postHandle( httpServletRequest,  httpServletResponse,  o, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        super.afterCompletion( httpServletRequest,  httpServletResponse,  o, e);
    }
}
