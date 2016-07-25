package com.qjk.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qjk.util.GraphicsUtil;
import com.qjk.util.VerifyCodeUtil;

@Controller
@RequestMapping("/image")
public class ImageController {

	@RequestMapping(value="/verifycode",method=RequestMethod.GET)
	public void drawVerfiyImage(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		System.out.println("drawVerfiyImage");
		String content = VerifyCodeUtil.randomCode(4);	
		request.getSession(true).setAttribute("code", content);
		ServletOutputStream out = response.getOutputStream();
		GraphicsUtil.drawImage(content, out);
		out.flush();
		out.close();
	}
}
