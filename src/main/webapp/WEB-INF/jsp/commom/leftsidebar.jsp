<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="panel-group col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
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
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">文件管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <li role="presentation">
                     <form action="/administrator/upLoad.do" method="post" enctype="multipart/form-data">
                            <input type="file" name="file" width="120px" >
                            <input type="submit" value="上传">
                    </form>
                </li>
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
</script>
</body>
</html>
