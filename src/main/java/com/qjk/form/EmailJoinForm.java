package com.qjk.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class EmailJoinForm {
	private String imcode;
	private String email;
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

	@NotNull(message="请输入邮箱")
	@Email(message="请输入正确的邮箱")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
