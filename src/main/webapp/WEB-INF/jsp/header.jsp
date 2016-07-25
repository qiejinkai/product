<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--header-->
<div id="header">
	<div class="header">
    	<a class="logo" href="/"></a>
        <div class="header_r">
           <c:if test="${empty user}">
            <div class="header_login" style="">
            	<a href="/login/registe">注册</a>
                <a href="/login/login">登录</a>            	
            </div>
            </c:if>
            
           <c:if test="${!empty user}">
            <div class="header_user">
            	<div class="header_logo">
                	<em>
                    	<img src="img/default_logo.png" />                        
                    </em>
                    <i>89</i>
                    <span>
                    	${user.nick}
                    </span>
                </div>
                <div class="user_nav" id="user_nav">
                	<em></em>
                	<ul>
                    	<li><a>我发起的</a></li>
                        <li><a>我支持的</a></li>
                        <li><a>我的消息</a></li>
                        <li><a>个人资料</a></li>
                        <li><a href="/login/logout">安全退出</a></li>
                	</ul>
                </div>
                <script>
                	$(function(){
						$('.header_logo').hover(function(){
							$('#user_nav').show();							
							});
							$('#user_nav').bind("mouseleave",function(){
							$('#user_nav').hide();							
							});
						
						});
                </script>
            </div>
            
            </c:if>
            
        	<div class="header_search">
            	<input type="text" class="search_text" />
                <input type="button" class="header_btn" />
            </div>
        </div>
        
    </div>
</div>
<!--header_nav-->
<div id="header_nav">
	<div class="header_nav">
    	<em>
            <a>首页</a>
            <a class="selected" id="more_porject">浏览项目</a>
            <a>发起项目</a>
            <a class="last">帮助中心</a>
        </em>
        <span>客户电话：400-086-4896</span>
        <div class="user_nav" id="more_porject_ul">
                	<em></em>
                	<ul>
                    	<li><a>武侠出版</a></li>
                        <li><a>现代都市</a></li>
                        <li><a>玄幻奇幻</a></li>
                        <li><a>校园青春</a></li>
                        <li><a>网络英雄</a></li>
                	</ul>
       </div>
       
        <script>
                	$(function(){
						$('#more_porject').hover(function(){
							$('#more_porject_ul').show();							
							});
							$('#more_porject_ul').bind("mouseleave",function(){
							$('#more_porject_ul').hide();							
							});
						
						});
                </script>
    </div>
</div>
</body>
</html>