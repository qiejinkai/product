package com.qjk.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import com.qjk.data.Sms;
import com.qjk.http.CURL;

public class SmsSendHelper {

	public final static String url = "http://cf.51welink.com/submitdata/Service.asmx/g_Submit?sname=dlfdycwl&spwd=2qzmgVM3&scorpid=&sprdid=1012888&sdst={phone}&smsg={body}";
	public final static String prefix = "【小骨投】";
	public final static String charset = "utf-8";
	public final static String method = "GET";

	public static Sms sendSms(Sms sms) throws UnsupportedEncodingException {

		String url_ = url;

		url_ = url_.replace("{phone}", sms.getPhone());
		url_ = url_.replace("{body}", URLEncoder.encode(SmsSendHelper.prefix
				+ sms.getContent(), charset));

		try {

			String text = "POST".equals(method) ? CURL.post(new URL(url_))
					.exec() : CURL.get(new URL(url_)).exec();
			System.out.println(text);
			sms.setResponse(text);
			sms.setStatus(Sms.STATUS_OK);

		} catch (Throwable ex) {
			sms.setResponse(ex.getMessage());
			sms.setStatus(Sms.STATUS_FAIL);

		}

		return sms;
	}

}
