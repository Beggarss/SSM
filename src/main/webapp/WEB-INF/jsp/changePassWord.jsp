<%--
  Created by IntelliJ IDEA.
  User: lata
  Date: 2019/5/21
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form id="form"  method="post" action="/hrms/changePassWord.do">
        员工id<input type="text" name="id"  ><br>
        员工邮箱<input type="text" name="email"><br>
        新密码<input type="password" name="passWord"><br> <span>${message}</span>
        <input type="submit" name="submit" value="确认更改">
    </form>
</body>
</html>
