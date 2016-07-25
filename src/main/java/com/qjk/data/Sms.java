package com.qjk.data;

import java.io.Serializable;

/**
 * 短信息
 * @author qiejinkai
 *
 */
public class Sms implements Serializable {
	/**
	 * 未处理
	 */
	public final static int STATUS_NONE = 0;
	
	/**
	 * 失败
	 */
	public final static int STATUS_FAIL = 300;
	
	/**
	 * 成功
	 */
	public final static int STATUS_OK = 200;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long messageId;
	private String phone;
	private String content;
	private long ctime;
	private int status;
	private String response;
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getCtime() {
		return ctime;
	}
	public void setCtime(long ctime) {
		this.ctime = ctime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
		
	
}
