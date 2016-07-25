package com.qjk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjk.exception.SmsException;
import com.qjk.service.ISmsService;
import com.qjk.util.Value;
import com.qjk.util.VerifyCodeUtil;


/**
 * 
 * @author qiejinkai
 *
 */
@Controller
@RequestMapping("/notify")
public class NotifyController {
	
	@Resource
	ISmsService smsService;

	@RequestMapping(value="/phone",method=RequestMethod.GET)
	@ResponseBody
	public Object phoneJoinNotify(HttpServletRequest request, @RequestParam("phone") String phone,@RequestParam("verifyCode") String verifyCode){
		String code = (String) request.getSession().getAttribute("code");
		Map<String, String> resultMap = new HashMap<String,String>();
		if(Value.isEmpty(phone)){
			resultMap.put("error", "手机号为空");
		}
		if(Value.isEmpty(verifyCode)){
			resultMap.put("error", "验证码为空");
		}
		if(!verifyCode.equals(code)){
			resultMap.put("error", "验证码错误");
		}

		String content = VerifyCodeUtil.randomCode(4);	
		request.getSession().setAttribute("phoneCode", content);
		try {
			smsService.sendSms(phone, content);
			request.getSession().setAttribute("phoneCode", content);
		} catch (SmsException e) {
			resultMap.put("error", e.getMessage());
		}
		return resultMap;
	}
}
