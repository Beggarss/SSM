package com.hrms.controller;

import com.hrms.model.Attendence;
import com.hrms.model.Employee;
import com.hrms.service.AttendenceService;
import com.hrms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/hrms")
public class PunchController {
    @Autowired
    private AttendenceService attendenceService;
    @RequestMapping("/punchIn")
    public ModelAndView punchIn(HttpServletRequest httpServletRequest) throws ParseException {
        HttpSession session=httpServletRequest.getSession();
        int id=Integer.parseInt(session.getAttribute("employee").toString());
        Date date =new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//考勤时间格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//打卡时间格式化
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Calendar ca2 = Calendar.getInstance();
        ca2.set(Calendar.HOUR_OF_DAY, 21);
        ca2.set(Calendar.MINUTE, 0);
        ca2.set(Calendar.SECOND, 0);
        Date inTime = format.parse(format.format(cal.getTime()));
        Date offTime = format.parse(format.format(ca2.getTime()));
        Date nowTime =format.parse(format.format(date));//打卡时间
        Date today =dateFormat.parse(dateFormat.format(date));
        Attendence attendence = new Attendence();
        attendence.setEmployeeId(id);
        attendence.setAttendenceDate(today);
        //查询员工是否打卡
        if(attendenceService.isPounchIn(attendence)==null) {
            //attendenceService.punchIn(attendence);
            attendence.setWorkTime(nowTime);

            //迟到
            int result;
            if (nowTime.before(offTime) && nowTime.after(inTime)) {
                attendence.setLate(true);
                result = attendenceService.punchIn(attendence);
            } else {
                //未迟到
                attendence.setLate(false);
                result = attendenceService.punchIn(attendence);
            }
            if(result>0){
                httpServletRequest.setAttribute("punchInMessage","打卡成功！");
            }else{
                httpServletRequest.setAttribute("punchInMessage","打卡失败!");
            }
        }else{
            httpServletRequest.setAttribute("punchInMessage","今天已经打卡！");
        }
        return new ModelAndView("punch");
    }
    @RequestMapping("/punch")
    public  ModelAndView punchOut( HttpServletRequest httpServletRequest) throws ParseException {
        HttpSession session =httpServletRequest.getSession();
        int id = Integer.parseInt(session.getAttribute("employee").toString());
        Attendence attendence = new Attendence();
        attendence.setEmployeeId(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//考勤时间格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//打卡时间格式化
        Date today= dateFormat.parse(dateFormat.format(new Date()));
        attendence.setAttendenceDate(today);
        Date nowTime = format.parse(format.format(new Date()));
        Calendar ca2 = Calendar.getInstance();
        ca2.set(Calendar.HOUR_OF_DAY, 21);
        ca2.set(Calendar.MINUTE, 0);
        ca2.set(Calendar.SECOND, 0);
        Date offTime = format.parse(format.format(ca2.getTime()));
       // httpServletRequest.setAttribute("punchOutMessage","下班打卡成功");
        if(nowTime.before(offTime)){
            httpServletRequest.setAttribute("punchOutMessage","没到下班时间，不能打卡！");
        }else{
            attendenceService.pounchOut(attendence);
            httpServletRequest.setAttribute("punchOutMessage","下班打卡成功!");
        }
      //  httpServletRequest.setAttribute("punchOutMessage","下班打卡成功！");
        return new ModelAndView("punch");
    }
}
