package com.hrms.controller;

import com.hrms.model.*;
import com.hrms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RoleService roleService;
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index(HttpServletRequest httpServletRequest) {
        // Integer id =Integer.valueOf(super.getAvailablePrincipal(principalCollection).toString());
        String id = "17";
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
        Employee employee = employeeService.selectByPrimaryKey(id);
        String userName = employee.getEmpName();
            System.out.println(userName);
            System.out.println(employee);
        if (null != employee) {
            for (userRoleKey userRoleKey: userRoleService.getRoles(userName)) {
                //roleSet.add(role.getRole());
                String roleName=userRoleKey.getRoleName();
                Role role =roleService.getRoles(roleName);
                System.out.println(role.getRole());
                roleSet.add(role.getRole());
                Integer id1 = role.getId();
                for (RolePermissionKey rolePermissionKey: rolePermissionService.getPermissions(id1)) {
                    List<Permission> permissions = permissionService.getPermissions(rolePermissionKey.getPermissionId());
                    for (Permission permission : permissions) {
                        permissionSet.add(permission.getPermission());
                        System.out.println(permission.getPermission());
                    }
                }
            }
        }
        return "test";
    }
}
