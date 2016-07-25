function reg(str, regx, notnull, name, callback) {
	//alert(1);
	var msg = "";
	//var regx2 = new RegExp(regx);
	if (str == null || str.length == 0) {
		if (notnull) {
			msg = name + "不能为空";
		}
	} else if (regx != null && !regx.test(str)) {
		msg = "请输入正确的" + name;
	}
	//alert(msg);
	if (msg.length != 0) {
		if (callback != null && typeof callback === "function") {
			callback(msg);
		}
		return false;
	} else {
		return true;
	}
}

function regPhone(phone, callback) {

	return reg(phone, /^\d{11}$/, true, '手机号', callback);

}

function regEmail(email, callback) {

	return reg(email,
			/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})$/,
			true, '邮箱', callback);

}

function regVerifyCode(verifyCode, callback) {

	return reg(verifyCode, /^\d{4}$/, true, '验证码', callback);

}

function regPassword(password, callback) {
	return reg(password, /^.{6,24}$/, true, '密码', callback);
}
