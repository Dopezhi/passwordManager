<%--
  Created by IntelliJ IDEA.
  User: Dopezhi
  Date: 2018/7/20
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
    <meta charset="utf-8">
    <title>密码管理系统登录</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <!-- web 路径
        不以/开始的相对路径，找资源，以当前的资源的路径为基准，经常容易出问题
        以/开始的相对路径，找资源不是从当前资源开始，是以服务器的根路径开始
        htttp://localhost:3306/crud
     -->
    <!-- 引入jquey  -->
    <script src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
    <!-- 引入css样式  -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入js文件  -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style type="text/css" media="screen">
        .form-bg{
            background: #00b4ef;
        }
        .form-horizontal{
            background: #fff;
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }
        .form-horizontal .heading{
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }
        .form-horizontal .form-group{
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }
        .form-horizontal .form-control{
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-group i{
            position: absolute;
            top: 12px;
            left: 60px;
            font-size: 17px;
            color: #c8c8c8;
            transition : all 0.5s ease 0s;
        }
        .form-horizontal .form-control:focus + i{
            color: #00b4ef;
        }
        .form-horizontal .fa-question-circle{
            display: inline-block;
            position: absolute;
            top: 12px;
            right: 60px;
            font-size: 20px;
            color: #808080;
            transition: all 0.5s ease 0s;
        }
        .form-horizontal .fa-question-circle:hover{
            color: #000;
        }
        .form-horizontal .main-checkbox{
            float: left;
            width: 20px;
            height: 20px;
            background: #11a3fc;
            border-radius: 50%;
            position: relative;
            margin: 5px 0 0 5px;
            border: 1px solid #11a3fc;
        }
        .form-horizontal .main-checkbox label{
            width: 20px;
            height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            cursor: pointer;
        }
        .form-horizontal .main-checkbox label:after{
            content: "";
            width: 10px;
            height: 5px;
            position: absolute;
            top: 5px;
            left: 4px;
            border: 3px solid #fff;
            border-top: none;
            border-right: none;
            background: transparent;
            opacity: 0;
            -webkit-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }
        .form-horizontal .main-checkbox input[type=checkbox]{
            visibility: hidden;
        }
        .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
            opacity: 1;
        }
        .form-horizontal .text{
            float: left;
            margin-left: 7px;
            line-height: 20px;
            padding-top: 5px;
            text-transform: capitalize;
        }
        .form-horizontal .btn{
            float: right;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }
        #message{
            color: red;
        }
        @media only screen and (max-width: 479px){
            .form-horizontal .form-group{
                padding: 0 25px;
            }
            .form-horizontal .form-group i{
                left: 45px;
            }
            .form-horizontal .btn{
                padding: 10px 20px;
            }
        }
    </style>
</head>
<body background="image/newlook.jpg">
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">
                <img alt="Brand" src="image/edm.jpg" width="30px" height="30px">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <!-- <li><a href="#">学生管理系统管理端</a></li> -->
                <li><p class="navbar-text" style="font-size: 16px;">密码管理系统</p></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="http://localhost:8080/StuManagementSystem/login.jsp">登录</a>
                </li>
                <li>
                    <a href="http://localhost:8080/reg.jsp">注册</a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="email" class="form-control" id="login_input_loginid" placeholder="用户账号">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="login_input_password" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <span id="message"></span>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">忘记密码</span>
                    <button type="button" class="btn btn-default" id="login_btn">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="stuGetQuestionModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">请输入你的登录账号</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="stuId_input_quesion" class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-10">
                            <input type="text" name="stuNewPwd" class="form-control" id="stuId_input_quesion" >
                            <span id="helpBlock" class="help-block"></span>
                            <span class="icon"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="stu_question_btn">确定</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="stuSetNewPasswordModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">请重新修改你的密码</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="stuId_input_quesion" class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-10">
                            <input type="text" name="stuNewPwd" class="form-control" id="stuId_quetion_id" disabled="disabled" >
                            <!-- <span id="helpBlock" class="help-block"></span> -->
                            <span class="icon"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuId_input_quesion" class="col-sm-2 control-label">密保问题</label>
                        <div class="col-sm-10">
                            <input type="text" name="question" class="form-control" id="question"  disabled="disabled">
                            <!-- <span id="helpBlock" class="help-block"></span> -->
                            <span class="icon"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuId_input_quesion" class="col-sm-2 control-label">密保答案</label>
                        <div class="col-sm-10">
                            <input type="text" name="answer" class="form-control" id="answer"  >
                            <!-- <span id="helpBlock" class="help-block"></span> -->
                            <span class="icon"></span>
                        </div>
                    </div><div class="form-group">
                        <label for="stuId_input_quesion" class="col-sm-2 control-label">新密码</label>
                        <div class="col-sm-10">
                            <input type="text" name="stuNewPwd" class="form-control" id="new_password" >
                            <!-- <span id="helpBlock" class="help-block"></span> -->
                            <span class="icon"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="stu_reset_password_btn">确定</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    //正常的
    <%--$("#login_btn").click(function() {--%>
    <%--//利用后台记录登录的学号 显示页面一打开立马获取这个值 并渲染--%>
    <%--var stuId=$("#login_input_stuId").val();--%>
    <%--var stuPwd=$("#login_input_stuPwd").val();--%>
    <%--$.ajax({--%>
    <%--url:"${APP_PATH}/login/"+stuId,--%>
    <%--data:"stuPwd="+stuPwd,--%>
    <%--type:"POST",--%>
    <%--success:function(result){--%>
    <%--if(result.extend.key=="manager"){--%>
    <%--window.location.href = "http://localhost:8080/StuManagementSystem/index.jsp";--%>
    <%--return false;--%>
    <%--}--%>
    <%--if(result.code==200){--%>
    <%--$("#message").text(result.extend.msg);--%>
    <%--}else{--%>
    <%--window.location.href = "http://localhost:8080/StuManagementSystem/index2.jsp";--%>
    <%--}--%>
    <%--}--%>
    <%--});--%>
    <%--});--%>


    $("#checkbox1").click(function(){
        // reset_form("#stuGetQuestionModal");
        $('#stuGetQuestionModal').modal({
            backdrop:"true", //如果设置成static就不会消失
        });
    });
  
    $("#stu_question_btn").click(function(){
        var loginid=$("#stuId_input_quesion").val(); 
        $.ajax({
            url:"${APP_PATH}/user/forget_get_question.do",
            contentType:"application/x-www-form-urlencoded",
            data:"loginId="+loginid,
            type:"POST",
            success:function(result){
                if(result.status==0){
                    $("#stuGetQuestionModal").modal('hide');
                    getQuestion(loginid);
                    $('#stuSetNewPasswordModal').modal({
                        backdrop:"true", //如果设置成static就不会消失
                     });
               }else{
                    show_validate_msg("#stuId_input_quesion","error",result.msg);
               }
            }
        });
    });

    function getQuestion(loginid){
        $.ajax({
            url:"${APP_PATH}/user/forget_get_question.do",
            contentType:"application/x-www-form-urlencoded",
            data:"loginId="+loginid,
            type:"POST",
            success:function(result){
                setPassword(loginid,result);
            }
        });
    }


    function setPassword(loginid,result){
        // var stuData=result.data;
        $("#stuId_quetion_id").val(loginid);
        $("#question").val(result.msg);
    }

    $("#stu_reset_password_btn").click(function(){
        var loginid=$("#stuId_quetion_id").val();
        var question=$("#question").val();
        var answer=$("#answer").val();
         $.ajax({
            url:"${APP_PATH}/user/forget_check_answer.do",
            contentType:"application/x-www-form-urlencoded",
            data:{loginId:loginid,question:question,answer:answer},
            type:"POST",
            success:function(result){
                if(result.status==0){
                    var token=result.msg;
                    var new_password=$("#new_password").val();
                    // alert("正在修改密码");
                    resetPassword(loginid,new_password,token);
                }else{
                    alert("答案错误");
                }
            }
        });
    });

    function resetPassword(loginid,new_password,token){
         $.ajax({
            url:"${APP_PATH}/user/forget_reset_password.do",
            contentType:"application/x-www-form-urlencoded",
            data:{loginId:loginid,passwordNew:new_password,forgetToken:token},
            type:"POST",
            success:function(result){
                if(result.status==0){
                    alert("修改成功");
                }
                $("#stuSetNewPasswordModal").modal('hide');
            }
         });
    }

     function show_validate_msg(ele,status,msg) {
        $(ele).parent().removeClass("has-success has-error has-feedback");
        $(ele).next("span").text("");
        $(ele).next("span").next("span").removeClass("glyphicon glyphicon-ok form-control-feedback");
        $(ele).next("span").next("span").removeClass("glyphicon glyphicon-remove form-control-feedback");
        if(status=="success"){
            $(ele).parent().addClass("has-success has-feedback");
            $(ele).next("span").text(msg);
            $(ele).next("span").next("span").addClass("glyphicon glyphicon-ok form-control-feedback");
        }else{
            $(ele).parent().addClass("has-error has-feedback");
            $(ele).next("span").text(msg);
            $(ele).next("span").next("span").addClass("glyphicon glyphicon-remove form-control-feedback");
        }
    }

    function reset_form(ele) {
        $(ele)[0].reset();
        $(ele).find("*").removeClass("has-success has-error has-feedback");
        $(ele).find(".help-block").text("");
        $(ele).find(".icon").removeClass("glyphicon glyphicon-ok form-control-feedback");
        $(ele).find(".icon").removeClass("glyphicon glyphicon-remove form-control-feedback");
    }


    $("#login_btn").click(function() {
        var loginid=$("#login_input_loginid").val();
        var password=$("#login_input_password").val();
        //实验证明，这个是输出当前是选择（true） 不 （false）
        // alert($("#checkbox1").prop("checked"));
        // var dataStr=stuId+"-"+stuPwd+"-"+$("#checkbox1").prop("checked");
        <%--var str="${APP_PATH}/login.do";--%>
        // alert(loginid);
        // alert(password);
        $.ajax({
            url:"${APP_PATH}/user/login.do",
            // data:'{"loginId":loginid,"password":password}',
            contentType: "application/x-www-form-urlencoded",
            // data:{loginId:'+loginid+',password:'+password'},
            data:{loginId:loginid,password:password},

            type:"POST",
            success:function(result){
                 // if(result.extend.key=="manager"){
                 //     window.location.href = "http://localhost:8080/StuManagementSystem/index.jsp";
                 //     return false;
                 // }
                 if(result.status==1){
                     // $("#message").text(result.extend.msg);
                     $("#message").text(result.msg);
                 }else{
                     <%--$.ajax({--%>
                         <%--url:"${APP_PATH}/remember/"+dataStr,--%>
                         <%--type:"POST",--%>
                         <%--success:function (result) {--%>

                        <%--}--%>
                     <%--});--%>
                    window.location.href = "http://localhost:8080/user_show.jsp";
                 }
                // if(result.status==0){
                //     alert("登录成功");
                //
                // }else{
                //     alert(result.msg);
                // }

            }
        });
    });





</script>


</body>
</html>