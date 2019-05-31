<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工管理页面</title>
</head>
<body>
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>
    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
    <div class="hrms_body" style="position:relative; top:-15px;">
        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>
        <!-- 中间员工表格信息展示内容 -->
        <div class="emp_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li><a href="#">员工管理</a></li>
                        <li class="active">员工新增</li>
                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="emp_table">
                    <tr>
                        <th>员工姓名</th>
                        <th>邮箱</th>
                        <th>性别</th>
                        <th>部门id</th>
                        <th>职位</th>
                    </tr>

                    <form action="/administrator/doAddEmployee.do" method="post">
                    <tr>
                        <td><input type="text" id="name" name="name" ></td>
                        <td><input type="text" id="email" name="email"></td>
                        <td><input type="text" id="gender" name="gender"></td>
                        <td><input type="text" id="departmentId" name="departmentId"></td>
                        <td><input type="text" id="position" name="position"></td>
                    </tr>
                        <tr>
                            <td><input type="submit" id="确定"></td>
                        </tr>
                        <tr>
                            ${addEmployeeMessage}
                        </tr>
                    </form>



                </table><!-- /.panel panel-success -->
            </div>
    </div><!-- /.emp_info -->

    <!-- 尾部 -->
    <%@ include file="./commom/foot.jsp"%>
</div><!-- /.hrms_body -->
</div><!-- /.container -->


</body>
</html>
