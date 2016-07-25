package com.qjk.http.impl;

import java.net.URL;

import com.qjk.http.IGet;


public class HttpGet extends HttpMessage implements IGet {

	public HttpGet(URL url) throws Throwable{
		super(url);
		conn.setRequestMethod("GET");
		conn.setDoOutput(false);
		conn.setDoInput(true);
	}
	
}
