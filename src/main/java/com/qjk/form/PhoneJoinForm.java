package com.qjk.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PhoneJoinForm {
	private String phone;
	private String password;
	private String repassword;
	private String code;
	private String imcode;
	private String agree;
	
	@NotNull(message="请勾选同意服务协议")
	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

	@NotNull(message="请输入图片验证码")
	public String getImcode() {
		return imcode;
	}

	public void setImcode(String imcode) {
		this.imcode = imcode;
	}


	@NotNull(message="请输入手机号")
	@Pattern(regexp="[0-9]{11}",message="请输入正确的手机号")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@NotNull(message="请输入密码")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotNull(message="请再次输入密码")
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@NotNull(message="请输入短信验证码")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}
