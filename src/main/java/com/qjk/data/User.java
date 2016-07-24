package com.qjk.data;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户实体
 * @author qiejinkai
 *
 */

public class User implements Serializable{
	
	
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;
	
	
	public User() {
		
	}
	private long uid;
	
	private String nick;
	
	private String password;
	
	private String phone;
	
	private String email;
	
	private String logo;
	
	private List<UserOption> options;
		
	public List<UserOption> getOptions() {
		return options;
	}
	public void setOptions(List<UserOption> options) {
		this.options = options;
	}
	
	
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	@Size(min=1,max=20,message="昵称应在1-20位之间")
	@NotEmpty(message="昵称不能为空")
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	@Size(min=6,max=24,message="密码应在6-24位之间")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@NotEmpty(message="电话不能为空")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Email(message="email格式不正确")
	@NotEmpty(message="email不能为空")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	

}
