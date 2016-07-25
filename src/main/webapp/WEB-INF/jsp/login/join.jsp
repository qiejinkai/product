<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    $(function () {
        var message="${error}";
        //alert(message);
        if (message != ''){
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
        <form id="phoneJoin" method="post" action="/login/phoneJoin" >
            <div class="form_filed">
                <input name="phone" class="form_text" placeholder="输入手机号" />
            </div>
            <div class="form_filed">
                <input name="imcode"  class="form_text join_text" placeholder="输入图片验证码" />
                <img class="img_code" src="http://tyhm.v2.eechou.com/api/open/user/login_code?r=0.5932440687902272" />
            </div>
            <div class="form_filed">
                <input name="code"  class="form_text join_text" placeholder="输入短信验证码" />
                <input type="button" class="form_btn get_code" value="获取验证码"/>
            </div>
           <div class="form_filed">
                <input type="password" name="password"  class="form_text" placeholder="输入密码" />
            </div>
            <div class="form_filed">
                <input type="password" name="repassword"  class="form_text" placeholder="确认密码" />
            </div>
            <div class="form_filed">
                <input type="submit" class="form_btn" value="注  册"/>
            </div>
            <div class="form_link">
            	<input type="checkbox" name="agree" class="form_checkbox" value="1"/>
                
                <span class="left">
                    我同意<a>《平台服务协议》</a>
                </span>
                <a class="right">已有账号</a>
            </div>
        </form>
        </div>
        <!--join_phone-->
        <div id="join_email" style="display: ${empty emailJoin ?'none':''}">
        <form id="emailJoin"  method="post"  action="/login/emailJoin" >
            <div class="form_filed" >
                <input name="email"  class="form_text" placeholder="输入您的常用邮箱" />
            </div>
            <div class="form_filed">
                <input name="code"  class="form_text join_text" placeholder="输入图片验证码" />
                <img class="img_code" src="http://tyhm.v2.eechou.com/api/open/user/login_code?r=0.5932440687902272" />
            </div>
           
            <div class="form_filed">
                <input type="submit" class="form_btn" value="注  册"/>
            </div>
            <div class="form_link">
            	<input type="checkbox" name="agree" class="form_checkbox" value="1" />
                <span class="left">
                    我同意<a>《平台服务协议》</a>
                </span>
                <a class="right">已有账号</a>
            </div>
            </form>
        </div>
        
        <!--join_phone-->
        
    </div>
</div>
<script>
	
	var imgUrl="/image/verifycode";

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
	
	$(function(){
		
		var callback = function (message){
			$.tip(message);
		}
		
        var ed = $('#login_form');
        $('.join_nav li', ed).bind('click', function () {
            $(this).addClass("selected").siblings("li").removeClass("selected");
            $('#' + $(this).attr('rel')).show().siblings('div').hide();
        });
        
		$('.img_code').attr("src",imgUrl);
		$('.img_code').bind('click',function(){
			changeImg($(this));
		});

		var pj = $('#phoneJoin');
 		$("input[name=phone]",pj).bind('change',function(){
			
			regPhone(this.value,callback);
		});		
 		$("input[name=password]",pj).bind('change',function(){
		
			regPassword(this.value,callback);
		});		
		$("input[name=imcode]",pj).bind('change',function(){
		
			regVerifyCode(this.value,callback);
		});			
		$("input[name=code]",pj).bind('change',function(){
		
			regVerifyCode(this.value,callback);
		});
		
		pj.bind("submit",function(){
			
			return false;
		});
		
        function countdown(count, obj) {
            window.setTimeout(function () {
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
		
		$(".get_code",pj).bind('click',function(){
			var phone = pj.find('input[name=phone]').val().trim();
            var verifycode = pj.find('input[name=imcode]').val().trim();
            if (!regPhone(phone,callback)) {
                return;
            }
            if (!regVerifyCode(verifycode,callback)) {
                
                return;
            }
            $.ajax({
                url: '/notify/phone',
                type: 'GET',
                data: 'phone=' + phone + '&verifyCode=' + verifycode,
                dataType: 'json',
                success: function (res) {
                    if (res.error) {
                    	$.tip(res.error);
                        
                    	$('.img_code').attr("src",imgUrl);
                    } else {
                        var el = $('.get_code');
                        var totalSeconds = 120;
                        el.attr('disabled', 'disabled');
                        el.val(totalSeconds + '秒');
                        countdown(totalSeconds, el);
                        $.tip('短信已发送到您的手机上，请注意查收！',true);
//                        $.tip(errMsg);
                    }
                }, error: function () {
                	$.tip('服务器出错！');
                   
                }
            });
		});
		
		
	});

	
</script>
</body>
</html>