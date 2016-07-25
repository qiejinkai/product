<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/login/login.css" />
<script type="text/javascript" src="../js/jquery.mini.js"></script>
<script type="text/javascript" src="../js/jquery.tip.js"></script>

</head>
<body>
<jsp:include page="../header.jsp"/>
<script type="text/javascript">
    $(function () {
        var message="${error}";
        if (message != ''){
            console.log(message);
            $.tip(message);
        }
    });
</script>

<!--header-->
<div class="warp" id='login_mian'>
	<div class="login_title">
    	<span>账号登录</span>        
    </div>
    <div id="login_form">
    <sf:form method="post"  commandName="loginForm">
    	<div class="form_filed">
        	<sf:input path="account" type="text" class="form_text" placeholder="输入手机号/邮箱" />
        </div>
        <div class="form_filed">
        	<sf:password  path="password" class="form_text" placeholder="输入密码" />
        </div>
        
        <div class="form_filed">
        	<input type="submit" class="form_btn" value="登  录"/>
        </div>
       </sf:form>
        <div class="form_link">
        	<a class="left">忘记密码</a>
            <a class="right">注册新账号</a>
        </div>
        
        <div id='login_ways'>
        	<h1>
            	<span>合作账号登录</span>
            </h1>
            <div class="login_ways">
            	<a class="login_ways_qq"></a>
                <a class="login_ways_wecaht"></a>
                <a class="login_ways_sina"></a>
            </div>
        </div>
    </div>


</div>
</body>
</html>