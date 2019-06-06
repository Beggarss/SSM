package realm;

import com.hrms.mapper.PermissionMapper;
import com.hrms.mapper.RolePermissionMapper;
import com.hrms.model.*;
import com.hrms.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    UserRoleService  userRoleService;
    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RoleService roleService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
       String id= token.getUsername();
        String password=employeeService.selectByPrimaryKey(id).getEmpPassword();
        if(password==null){
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(id,password,"customRealm");
        info.setCredentialsSalt(ByteSource.Util.bytes("chengsong"));
       // this.setAuthenticationSession(id);
        return info;

    }
//    private void setAuthenticationSession(Object value){
//        Subject currentUser = SecurityUtils.getSubject();
//        if(null != currentUser){
//            Session session = currentUser.getSession();
//            System.out.println("当前Session超时时间为[" + session.getTimeout() + "]毫秒");
//            session.setTimeout(1000 * 60 * 60 * 2);
//            System.out.println("修改Session超时时间为[" + session.getTimeout() + "]毫秒");
//            session.setAttribute("currentUser", value);
//        }
 //   }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       // Integer id = Integer.valueOf(super.getAvailablePrincipal(principalCollection).toString());
     //   String id =principalCollection.getPrimaryPrincipal().toString();
       // String id=super.getAvailablePrincipal(principalCollection).toString();
       // String id =SecurityUtils.getSubject().getPrincipal().toString();
//        if(id==null){
//            id=SecurityUtils.getSubject().getSession().getAttribute("employee").toString();
//        }
//        System.out.println("123456");
//        System.out.println(id);
       // String id="1";
        String loginName = SecurityUtils.getSubject().getPrincipal().toString();
       // System.out.println(loginName);
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
        Employee employee = employeeService.selectByPrimaryKey(loginName);
        String userName = employee.getEmpName();
      //  System.out.println(employee);
        if (employee!=null) {
            for (com.hrms.model.userRoleKey userRoleKey: userRoleService.getRoles(userName)) {
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
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet)    ;
//        info.addRole("user");
//        info.addStringPermission("user:add");
//        System.out.println("12312412");
        return info;
    }
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject()
                .getPrincipals();
        super.clearCache(principals);
    }



    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("2","chengsong");
        System.out.println(md5Hash.toString());
    }
}
