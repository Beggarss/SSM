<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<div class="panel-group col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
    <shiro:hasRole name="admin">
    <ul class="nav nav-pills nav-stacked emp_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_emp">
                <span class="glyphicon glyphicon-user" aria-hidden="true">员工管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_emp">
                <li role="presentation"><a href="#" class="emp_info">员工信息</a></li>
                <li role="presentation"><a href="#" class="emp_add_btn">员工新增</a></li>
            </ul>
        </li>
    </ul>
    </shiro:hasRole>
    <shiro:hasRole name="user">
    <ul class="nav nav-pills nav-stacked emp_sidebar">
        <li role="presentation" class="active">
            <a href="#" class="punch_in" data-toggle="collapse" data-target="#collapse_emp">
                <span class="glyphicon glyphicon-user" aria-hidden="true">上班打卡</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_emp1">
                <li role="presentation"><a >${punchInMessage}</a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#" class="punch_out"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">下班打卡</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept1">
                <li role="presentation"><a >${punchOutMessage}</a></li>
            </ul>
        </li>
    </ul>
    </shiro:hasRole>
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">

            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
              <shiro:hasRole name="admin" > <li role="presentation">
                     <form action="/administrator/upLoad.do" method="post" enctype="multipart/form-data">
                            <input type="file" name="file" width="120px" >
                            <input type="submit" value="上传">
                    </form>
            </li></shiro:hasRole>
                </a>
                <li role="presentation"><a >${uploadMessage}</a></li>
                <li><a href="#" class="load_down">文件下载</a></li>
            </ul>
        </li>
    </ul>


</div><!-- /.panel-group，#hrms_sidebar_left -->

<script type="text/javascript">
    //跳转到员工页面
    $(".emp_info").click(function () {
        $(this).attr("href", "/administrator/getAllEmployee.do");
    });
   //员工增加
    $(".emp_add_btn").click(function () {
        $(this).attr("href", "/administrator/addEmployee.do");
    });

    //文件下载
    $(".load_down").click(function () {
        $(this).attr("href","/administrator/download.do")
    });
    //跳转到上班打开控制器
    $(".punch_in").click(function () {
        $(this).attr("href", "/hrms/punchIn.do");
    });
    //跳转到下班打卡控制器
    $(".punch_out").click(function () {
        $(this).attr("href", "/hrms/punch.do");
    });
    //文件下载
    $(".load_down").click(function () {
        $(this).attr("href","/hrms/download.do")

    });
</script>
</body>
</html>
