<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="panel-group col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
    <ul class="nav nav-pills nav-stacked emp_sidebar">
        <li role="presentation" class="active">
            <a href="#" class="punch_in" data-toggle="collapse" data-target="#collapse_emp">
                <span class="glyphicon glyphicon-user" aria-hidden="true">上班打卡</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_emp">
                <li role="presentation"><a >${punchInMessage}</a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#" class="punch_out"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">下班打卡</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <li role="presentation"><a >${punchOutMessage}</a></li>
            </ul>

        </li>
    </ul>
    <li><a href="#" class="load_down">文件下载</a></li>


</div><!-- /.panel-group，#hrms_sidebar_left -->

<script type="text/javascript">
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
        $(this).attr("href","/administrator/download.do")

    });

    //员工清零这个功能暂未实现
    $(".emp_clearall_btn").click(function () {
        alert("对不起，您暂无权限进行操作！请先获取权限");
    });
    //部门清零这个功能暂未实现
    $(".dept_clearall_btn").click(function () {
        alert("对不起，您暂无权限进行操作！请先获取权限");
    });
</script>
</body>
</html>
