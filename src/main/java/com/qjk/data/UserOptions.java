package com.qjk.data;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 用户属性表
 * @author qiejinkai
 *
 */
public class UserOptions extends Data implements Serializable{

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;

	public UserOptions() {
		// TODO Auto-generated constructor stub
	}
	
	private String uid;
	
	private String name ;
	
	private String value;

	@Min(value=1,message="用户ID不能为空")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@NotNull(message="属性名不能为空")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull(message="属性值不能为空")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
	
}
