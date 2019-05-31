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
                        <li class="active">员工信息</li>
                        <li></li>
                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="emp_table">
                 <tr>
                    <th>员工编号</th>
                    <th>员工姓名</th>
                    <th>邮箱</th>
                    <th>性别</th>
                    <th>部门id</th>
                    <th>职位</th>
                 </tr>
                        <c:forEach items="${pageInfo.list}" var="employee">
                            <tr>
                                <td>${employee.empId}</td>
                                <td>${employee.empName}</td>
                                <td>${employee.empEmail}</td>
                                <td>${employee.empGender}</td>
                                <td>${employee.departmentId}</td>
                                <td>${employee.position}</td>
                            </tr>
                        </c:forEach>
                </table>
                <p>当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
                    页,总 ${pageInfo.total } 条记录</div></p>
            <a href="/administrator/getAllEmployee.do?pageNum=${pageInfo.firstPage}">第一页</a>
            <c:if test="${pageInfo.hasPreviousPage }">
                <a href="/administrator/getAllEmployee.do?pageNum=${pageInfo.pageNum-1}">上一页</a>
            </c:if>
            <c:if test="${pageInfo.hasNextPage }">
                <a href="/administrator/getAllEmployee.do?pageNum=${pageInfo.pageNum+1}">下一页</a>
            </c:if>
            <a href="/administrator/getAllEmployee.do?pageNum=${pageInfo.lastPage}">最后页</a>

            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->

        <!-- 尾部 -->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_body -->
</div><!-- /.container -->


</body>
</html>
