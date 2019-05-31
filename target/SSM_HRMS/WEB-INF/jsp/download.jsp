<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XXX公司人力资源系统后台</title>
</head>
<body>
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>

    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>
<div>
            <c:forEach items="${pageInfo.list}" var="dir">

                <li><a href="${dir.dir}"  download="${dir.dir.substring(dir.dir.lastIndexOf("_")+1)}">${dir.dir.substring(dir.dir.lastIndexOf("/")+1,dir.dir.lastIndexOf("."))}</a></li>
                <%--${dir.dir}--%>
            </c:forEach>
        <p>当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
            页,总 ${pageInfo.total } 条记录</div></p>
    <a href="/administrator/download.do?pageNum=${pageInfo.firstPage}">第一页</a>
    <c:if test="${pageInfo.hasPreviousPage }">
        <a href="/administrator/download.do?pageNum=${pageInfo.pageNum-1}">上一页</a>
    </c:if>
    <c:if test="${pageInfo.hasNextPage }">
        <a href="/administrator/download.do?pageNum=${pageInfo.pageNum+1}">下一页</a>
    </c:if>
    <a href="/administrator/download.do?pageNum=${pageInfo.lastPage}">最后页</a>

    <!-- 尾部 -->
    </div>
    </div>
    <%@ include file="./commom/foot.jsp"%>
</div><!-- /.hrms_container -->

</body>
</html>
