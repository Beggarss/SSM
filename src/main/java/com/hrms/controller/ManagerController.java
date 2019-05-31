package com.hrms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrms.model.Attendence;
import com.hrms.model.Employee;
import com.hrms.model.Document;
import com.hrms.service.AttendenceService;
import com.hrms.service.DirectoryService;
import com.hrms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/administrator")
public class ManagerController {
    @Autowired
    private  EmployeeService employeeService;
    @Autowired
    private AttendenceService attendenceService;
    @Autowired
    private DirectoryService directoryService;
    @RequestMapping("/managerLogin")
    public ModelAndView managerLogin(){
        return  new ModelAndView("managerLogin");
    }
    @RequestMapping("/managerPage")
    public ModelAndView managerPage(@RequestParam("id") String id,@RequestParam("password") String password){
        if(id.equals("1")&&password.equals("cs1072360540")) {
            return new ModelAndView("main");
        }else{ return  new ModelAndView("managerLogin");
        }
    }
    @RequestMapping("/getAllEmployee")
    public ModelAndView getEmployee(ModelMap map,@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue="1",value="pageSize") Integer pageSize){
      //  Integer pageSize=1;//每页显示的个数
        //分页查询
        pageSize=1;
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> list =employeeService.selectAllEmployee();//获取所有用户信息
        PageInfo<Employee> pageInfo =new PageInfo<>(list);
        map.addAttribute("pageInfo",pageInfo);
        return new ModelAndView("employeePage");
    }
    @RequestMapping("/getAllAttendence")
    public ModelAndView getAttendence(ModelMap map,@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue="1",value="pageSize") Integer pageSize){
        //  Integer pageSize=1;//每页显示的个数
        //分页查询
        pageSize=1;
        PageHelper.startPage(pageNum,pageSize);
        List<Attendence> list =attendenceService.selectAttendence();//获取所有打卡信息
        PageInfo<Attendence> pageInfo =new PageInfo<>(list);
//        for (Attendence attendence:list
//             ) {
//            System.out.println("。。。。。。。"+attendence.getEmployeeId());
//
//        }
//        System.out.println(list.size());
        map.addAttribute("pageInfo",pageInfo);
        return new ModelAndView("attendencePage");
    }
    @RequestMapping("/addEmployee")
    public ModelAndView addEmployee(){
        return new ModelAndView("employeeAdd");
    }
    @RequestMapping(value = "/doAddEmployee",method = RequestMethod.POST)
    public ModelAndView doAddEmployee(@RequestParam("name") String name, @RequestParam("email") String email,
                                      @RequestParam("gender") String gender, @RequestParam("departmentId") int id,
                                      @RequestParam("position") String position, HttpServletRequest httpServletRequest){
        Employee employee= new Employee();
        employee.setEmpName(name);
        employee.setEmpEmail(email);
        employee.setDepartmentId(id);
        employee.setEmpGender(gender);
        employee.setPosition(position);
        System.out.println(position);
        int result=employeeService.insert(employee);
        if(result>0){
            httpServletRequest.setAttribute("addEmployeeMessage","员工添加成功！");
        }else{
            httpServletRequest.setAttribute("addEmployeeMessage","员工添加失败！");
        }
        return new ModelAndView("employeeAdd");
    }
    @RequestMapping("/upLoad")
    public ModelAndView upLoad(MultipartFile file ,HttpServletRequest httpServletRequest) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String res =sdf.format(new Date());
        //上传文件保存的位置
        String path=httpServletRequest.getSession().getServletContext().getRealPath("resource/upload");
        //文件原始名称
        String fileName = file.getOriginalFilename();
        //新文件名称
        String newFileName= res+"_"+fileName;
        //新文件
        File newFile=new File(path+File.separator+File.separator+newFileName);
        //判断文件目录是否存在
        if(!newFile.getParentFile().exists()){
            //创建父目录
            newFile.getParentFile().mkdirs();
        }
        System.out.println(newFile.getAbsolutePath());
        //将数据写入磁盘中
        file.transferTo(newFile);
        httpServletRequest.setAttribute("uploadMessage","文件上传成功！");
        httpServletRequest.setAttribute("src",newFile);
        //将文件路径上传到数据库
        String dir="/resource/upload/"+newFileName;
        directoryService.insertDir(dir);
        return  new ModelAndView("main");
    }
    @RequestMapping("/download")
    public ModelAndView download(ModelMap map,@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue="1",value="pageSize") Integer pageSize){
        //  Integer pageSize=1;//每页显示的个数
        //分页查询
        pageSize=1;
        PageHelper.startPage(pageNum,pageSize);
        List<Document> list =directoryService.selectAllDir();//获取所有用户信息
        PageInfo<Document> pageInfo =new PageInfo<>(list);
        map.addAttribute("pageInfo",pageInfo);
        return new ModelAndView("download");
    }
}
