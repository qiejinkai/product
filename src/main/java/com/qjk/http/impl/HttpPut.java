package com.qjk.http.impl;

import java.net.URL;

import com.qjk.http.IPut;


public class HttpPut extends HttpPost implements IPut {

	public HttpPut(URL url) throws Throwable {
		super(url);
		conn.setRequestMethod("PUT");
	}

}
