<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/login/login.css" />
<script src="../js/jquery.mini.js"></script>
<script type="text/javascript" src="../js/jquery.tip.js"></script>
<script type="text/javascript" src="../js/validate.js"></script>
</head>	
<script type="text/javascript">
		$(function() {
			var message = "${error}";
			//alert(message);
			if (message != '') {
				console.log(message);
				$.tip(message);
				setTimeout(function(){

					window.location.href="/";
				},1000);
			}
		});
	</script>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="login_form">
		<div class="login_title">
			<span>邮箱注册</span>
		</div>
		<div id="email_join" >
			<form id="phoneJoin" method="post" action="/login/phoneJoin">
				<div class="form_filed">
				<input type="text" class="form_text" value="${email }" disabled="disabled" />
					 <input type="hidden" name="email" value="${email}" /> <input
						type="hidden" name="code" value="${code}" />
				</div>
				<div class="form_filed">
					<input type="password" name="password" class="form_text"
						placeholder="输入密码" />
				</div>
				<div class="form_filed">
					<input type="password" name="repassword" class="form_text"
						placeholder="确认密码" />
				</div>
				<div class="form_filed">
					<input type="submit" class="form_btn" value="注  册" />
				</div>
				<div class="form_link">
					<input type="checkbox" name="agree" class="form_checkbox" value="1" />
					<span class="left"> 我同意<a>《平台服务协议》</a>
					</span> <a class="right">已有账号</a>
				</div>
			</form>
		</div>

		<!--join_phone-->

	</div>
	<script type="text/javascript">
		$(function() {
			var callback = function(message) {
				$.tip(message);
			}
			var ej = $("#email_join");
			ej.bind('submit', function() {

				var email = ej.find('input[name=email]').val().trim();
				var code = ej.find('input[name=code]').val().trim();
				var agree = ej.find('input[type=checkbox]');
				var password = ej.find('input[name=password]').val().trim();
				var repassword = ej.find('input[name=repassword]').val().trim();
				if (!regEmail(email, callback)) {
					return false;
				}
				if (!agree.get(0).checked) {
					$.tip("请勾选同意平台协议");
					return false;
				}						
				if (!regPassword(password, callback)) {

					return false;
				}
				if (repassword != password) {
					$.tip("两次密码输入不一致");
					return false;
				}
				if (!agree.get(0).checked) {
					$.tip("请勾选同意平台协议");
					return false;
				}
				$.ajax({
					url : '/login/emailJoin',
					type : 'POST',
					data : {
						email : email,
						code : code,
						password : password
					},
					dataType : 'json',
					success : function(res) {
						if (res.error) {
							$.tip(res.error);
						} else {
							window.location.href="/";
						}
						return false;
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert(XMLHttpRequest.status);
						 alert(XMLHttpRequest.readyState);
						 alert(textStatus);
						return false;
					}
				});

				return false;
			});
		});
	</script>
</body>
</html>