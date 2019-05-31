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
                        <li><a href="#">出勤记录</a></li>
                        <form method="post" action="">

                        </form>

                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="emp_table">
                    <tr>
                        <th>打卡序号</th>
                        <th>打卡日期</th>
                        <th>员工id</th>
                        <th>上班打卡时间</th>
                        <th>下班打卡时间</th>
                        <th>是否迟到</th>

                    </tr>
                    <c:forEach items="${pageInfo.list}" var="employee">
                        <tr>
                            <td>${employee.attendenceId}</td>
                            <td>${employee.attendenceDate}</td>
                            <td>${employee.employeeId}</td>
                            <td>${employee.workTime}</td>
                            <td>${employee.offTime}</td>
                            <td>${employee.late}</td>
                        </tr>
                    </c:forEach>
                </table>
                <p>当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
                    页,总 ${pageInfo.total } 条记录</div></p>
            <a href="/administrator/getAllAttendence.do?pageNum=${pageInfo.firstPage}">第一页</a>
            <c:if test="${pageInfo.hasPreviousPage }">
                <a href="/administrator/getAllAttendence.do?pageNum=${pageInfo.pageNum-1}">上一页</a>
            </c:if>
            <c:if test="${pageInfo.hasNextPage }">
                <a href="/administrator/getAllAttendence.do?pageNum=${pageInfo.pageNum+1}">下一页</a>
            </c:if>
            <a href="/administrator/getAllAttendence.do?pageNum=${pageInfo.lastPage}">最后页</a>

        </div><!-- /.panel panel-success -->
    </div><!-- /.emp_info -->

    <!-- 尾部 -->
    <%@ include file="./commom/foot.jsp"%>
</div><!-- /.hrms_body -->
</div><!-- /.container -->


</body>
</html>
