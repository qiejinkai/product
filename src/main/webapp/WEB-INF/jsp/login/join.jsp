<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<script type="text/javascript">
		$(function() {
			var message = "${error}";
			//alert(message);
			if (message != '') {
				console.log(message);
				$.tip(message);
			}
		});
	</script>
	<!--header-->
	<div class="warp" id='login_mian'>
		<div class="login_title">
			<span>注册账号</span>
		</div>
		<div id="login_form">
			<ul class="join_nav">
				<li rel='join_phone' class="${empty phoneJoin ?'':'selected'}"><a>手机注册</a></li>
				<li rel='join_email' class="${empty emailJoin ?'':'selected'}"><a>邮箱注册</a></li>
			</ul>
			<div id="join_phone" style="display: ${empty phoneJoin ?'none':''}">
				<form id="phoneJoin" method="post" action="/login/phoneJoin">
					<div class="form_filed">
						<input name="phone" class="form_text" placeholder="输入手机号" />
					</div>
					<div class="form_filed">
						<input name="imcode" class="form_text join_text"
							placeholder="输入图片验证码" /> <img class="img_code"
							src="http://tyhm.v2.eechou.com/api/open/user/login_code?r=0.5932440687902272" />
					</div>
					<div class="form_filed">
						<input name="code" class="form_text join_text"
							placeholder="输入短信验证码" /> <input type="button"
							class="form_btn get_code" value="获取验证码" />
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
						<input type="checkbox" name="agree" class="form_checkbox"
							value="1" /> <span class="left"> 我同意<a>《平台服务协议》</a>
						</span> <a class="right">已有账号</a>
					</div>
				</form>
			</div>
			<!--join_phone-->
			<div id="join_email" style="display: ${empty emailJoin ?'none':''}">
				<form id="emailJoin" method="post" action="/login/emailJoin">
					<div class="form_filed">
						<input name="email" class="form_text" placeholder="输入您的常用邮箱" />
					</div>
					<div class="form_filed">
						<input name="imcode" class="form_text join_text"
							placeholder="输入图片验证码" /> <img class="img_code"
							src="http://tyhm.v2.eechou.com/api/open/user/login_code?r=0.5932440687902272" />
					</div>

					<div class="form_filed">
						<input type="submit" class="form_btn" value="注  册" />
					</div>
					<div class="form_link">
						<input type="checkbox" name="agree" class="form_checkbox"
							value="1" /> <span class="left"> 我同意<a>《平台服务协议》</a>
						</span> <a class="right">已有账号</a>
					</div>
				</form>
			</div>

			<!--join_phone-->

		</div>
	</div>
	<div class="warp" id='email_notice' style="display:none">
		<div class="login_title">
	    	<span>邮箱注册</span>        
	    </div>
	    <div id='join_email_back'>
	    	<div></div>
	        <h1>邮箱注册邮件已发送至你的邮箱<em>${email}</em>，<br />
				请在24小时内点击邮件内的链接完成注册。
	        </h1>
	        <h2>没有收到验证邮件，怎么办？</h2>
	        <p>看看是否在邮箱的垃圾邮件、广告邮件目录里<br />
	        稍等几分钟，若还未收到验证邮件，<a>重新发送验证邮件</a></p>
	    
	    </div>
	    
	</div>
	<script>
		var imgUrl = "/image/verifycode";

		function changeImg(img) {
			//alert(img);
			img.attr("src", chgUrl(imgUrl));
		}

		//加入时间戳，去缓存机制   
		function chgUrl(url) {
			var timestamp = (new Date()).valueOf();
			if ((url.indexOf("&") >= 0)) {
				url = url + "&r=" + timestamp;
			} else {
				url = url + "?r=" + timestamp;
			}
			return url;
		}

		$(function() {

			var callback = function(message) {
				$.tip(message);
			}

			var ed = $('#login_form');
			$('.join_nav li', ed).bind(
					'click',
					function() {
						$(this).addClass("selected").siblings("li")
								.removeClass("selected");
						$('#' + $(this).attr('rel')).show().siblings('div')
								.hide();
					});

			$('.img_code').attr("src", imgUrl);
			$('.img_code').bind('click', function() {
				changeImg($(this));
			});

			var pj = $('#phoneJoin');
			$("input[name=phone]", pj).bind('change', function() {

				regPhone(this.value, callback);
			});
			$("input[name=password]", pj).bind('change', function() {

				regPassword(this.value, callback);
			});
			$("input[name=imcode]", pj).bind('change', function() {

				regVerifyCode(this.value, callback);
			});
			$("input[name=code]", pj).bind('change', function() {

				regVerifyCode(this.value, callback);
			});

			pj.bind("submit", function() {

				return false;
			});

			function countdown(count, obj) {
				window.setTimeout(function() {
					count--;
					if (count >= 0) {
						obj.val(count + '秒');
						countdown(count, obj);
					} else {
						obj.val('获取验证码');
						obj.removeAttr('disabled');
					}
				}, 1000);
			}

			$(".get_code", pj).bind('click', function() {
				var phone = pj.find('input[name=phone]').val().trim();
				var verifycode = pj.find('input[name=imcode]').val().trim();
				if (!regPhone(phone, callback)) {
					return;
				}
				if (!regVerifyCode(verifycode, callback)) {

					return;
				}
				$.ajax({
					url : '/login/join/phoneCode',
					type : 'GET',
					data : 'phone=' + phone + '&verifyCode=' + verifycode,
					dataType : 'json',
					success : function(res) {
						if (res.error) {
							$.tip(res.error);

							$('.img_code').attr("src", imgUrl);
						} else {
							var el = $('.get_code');
							var totalSeconds = 120;
							el.attr('disabled', 'disabled');
							el.val(totalSeconds + '秒');
							countdown(totalSeconds, el);
							$.tip('短信已发送到您的手机上，请注意查收！', true);
							//                        $.tip(errMsg);
						}
					},
					error : function() {
						$.tip('服务器出错！');

					}
				});
			});
			pj.bind('submit',
					function() {

						var phone = pj.find('input[name=phone]').val().trim();
						var phoneCode = pj.find('input[name=code]').val()
								.trim();
						var password = pj.find('input[name=password]').val()
								.trim();
						var repassword = pj.find('input[name=repassword]')
								.val().trim();
						var agree = pj.find('input[type=checkbox]');
						if (!regPhone(phone, callback)) {
							return false;
						}
						if (!regVerifyCode(phoneCode, callback)) {

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
							url : '/login/phoneJoin',
							type : 'POST',
							data : {
								phone : phone,
								phoneCode : phoneCode,
								password : password
							},
							dataType : 'json',
							success : function(res) {
								if (res.error) {
									$.tip(res.error);
								} else {
									window.location.href = "/";
								}
								return false;
							},
							error : function() {
								$.tip('服务器出错！');
								return false;
							}
						});

						return false;
					});

			var ej = $("#emailJoin");
			$("input[name=email]", ej).bind('change', function() {

				regEmail(this.value, callback);
			});
			$("input[name=imcode]", ej).bind('change', function() {

				regVerifyCode(this.value, callback);
			});
			
			ej.bind('submit',
					function() {

						var email = ej.find('input[name=email]').val().trim();
						var code = ej.find('input[name=imcode]').val()
								.trim();
						var agree = ej.find('input[type=checkbox]');
						if (!regEmail(email, callback)) {
							return false;
						}
						if (!regVerifyCode(code, callback)) {

							return false;
						}
						if (!agree.get(0).checked) {
							$.tip("请勾选同意平台协议");
							return false;
						}
						$.ajax({
							url : '/login/join/emailSend',
							type : 'POST',
							data : {
								email : email,
								verifyCode : code
							},
							dataType : 'json',
							success : function(res) {
								if (res.error) {
									$.tip(res.error);
								} else {
									$("#login_mian").css("display","none");
									$("#email_notice").css("display","");
								}
								return false;
							},
							error :  function(XMLHttpRequest, textStatus, errorThrown) {
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