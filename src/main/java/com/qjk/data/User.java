package com.qjk.data;

import java.io.Serializable;

/**
 * �û�ʵ��
 * @author qiejinkai
 *
 */
public final class User extends Data implements Serializable{
	
	/**
	 * �汾��
	 */
	private static final long serialVersionUID = 1L;

	private String nick;
	
	private String password;
	
	private int age;
	
	private String phone;
	
	private String email;
	
	private String logo;
	
	private String qr;
	
	public User() {
		
	}
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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

	public String getQr() {
		return qr;
	}

	public void setQr(String qr) {
		this.qr = qr;
	}
	
	

}
