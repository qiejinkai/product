package com.qjk.data;

import java.io.Serializable;

/**
 * 实体类
 * @author qiejinkai
 *
 */
public class Data  implements Serializable{
	
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;

	private long objectId;

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}
	

}
