package com.qjk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjk.data.User;
import com.qjk.exception.SmsException;
import com.qjk.exception.UserException;
import com.qjk.form.LoginForm;
import com.qjk.service.ISmsService;
import com.qjk.service.IUserService;
import com.qjk.util.DigestUtil;
import com.qjk.util.MailSendHelper;
import com.qjk.util.Value;
import com.qjk.util.VerifyCodeUtil;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource
	private IUserService userService;
	@Resource
	ISmsService smsService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin(HttpServletRequest request,
			@ModelAttribute("loginForm") LoginForm loginForm) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			return "redirect:/";
		}
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, params = {
			"account", "password" })
	public String login(LoginForm loginForm, Model model,
			HttpServletRequest request) {

		try {
			User user = userService.login(loginForm.getAccount(),
					loginForm.getPassword());
			request.getSession().setAttribute("user", user);

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());

			return "login/login";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "redirect:/";
	}

	@RequestMapping(value = { "/join" }, method = RequestMethod.GET)
	public String join(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			return "redirect:/";
		}
		model.addAttribute("phoneJoin", "true");
		return "login/join";
	}

	@RequestMapping(value = "/phoneJoin", method = RequestMethod.POST)
	@ResponseBody
	public Object phoneJoin(HttpServletRequest request,
			@RequestParam("phone") String phone,
			@RequestParam("password") String password,
			@RequestParam("phoneCode") String phoneCode) {
		String code = (String) request.getSession().getAttribute(
				"phoneJoinCode");
		Map<String, String> resultMap = new HashMap<String, String>();
		if (Value.isEmpty(phoneCode)) {
			resultMap.put("error", "验证码为空");
			return resultMap;
		}
		if (Value.isEmpty(code)) {
			resultMap.put("error", "请重新获取手机验证码");
			return resultMap;
		}
		if (!(phone + "/" + phoneCode).equals(code)) {
			resultMap.put("error", "验证码错误");
			return resultMap;
		}
		try {
			User user = userService.joinPhone(phone, password);
			request.getSession().removeAttribute("phoneJoinCode");
			request.getSession().setAttribute("user", user);
		} catch (UserException e) {
			resultMap.put("error", e.getMessage());
		}
		return resultMap;
	}

	@RequestMapping(value = "/emailJoin", method = RequestMethod.POST)
	@ResponseBody
	public Object emailJoin(HttpServletRequest request,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("code") String code) {
		Map<String, String> resultMap = new HashMap<String, String>();
		if (Value.isEmpty(code)) {
			resultMap.put("error", "验证码为空");
			return resultMap;
		}
		String encode = DigestUtil.md5(email);

		if (!code.equals(encode)) {
			resultMap.put("error", "验证码错误");
			return resultMap;
		}

		try {
			User user = userService.joinEmail(email, password);
			request.getSession().setAttribute("user", user);
			return resultMap;
		} catch (UserException e) {
			resultMap.put("error", e.getMessage());
		}
		return resultMap;

	}

	@RequestMapping(value = "/emailJoin", method = RequestMethod.GET)
	public String emailJoin(Model mode, HttpServletRequest request,
			@RequestParam("email") String email,
			@RequestParam("code") String code) {

		if (Value.isEmpty(email)) {
			mode.addAttribute("error", "邮箱为空");

		} else if (Value.isEmpty(code)) {
			mode.addAttribute("error", "验证码为空");
		} else {
			String encode = DigestUtil.md5(email);

			if (!code.equals(encode)) {
				mode.addAttribute("error", "验证码错误");
			}
		}
		
		mode.addAttribute("email",email);
		mode.addAttribute("code", code);
		return "login/email_join";

	}

	@RequestMapping(value = "/join/phoneCode", method = RequestMethod.GET)
	@ResponseBody
	public Object phoneCodeNotify(HttpServletRequest request,
			@RequestParam("phone") String phone,
			@RequestParam("verifyCode") String verifyCode) {
		String code = (String) request.getSession().getAttribute("code");
		Map<String, String> resultMap = new HashMap<String, String>();

		if (Value.isEmpty(verifyCode)) {
			resultMap.put("error", "验证码为空");
			return resultMap;
		}
		if (!verifyCode.equals(code)) {
			resultMap.put("error", "验证码错误");
			return resultMap;
		}

		String content = VerifyCodeUtil.randomCode(4);
		try {
			smsService.sendSms(phone, content);
			request.getSession().setAttribute("phoneJoinCode",
					phone + "/" + content);

			request.getSession().removeAttribute("code");
		} catch (SmsException e) {
			resultMap.put("error", e.getMessage());
		}
		return resultMap;
	}

	@RequestMapping(value = "/join/emailSend", method = RequestMethod.POST)
	@ResponseBody
	public Object emailSendNotify(HttpServletRequest request,
			@RequestParam("email") String email,
			@RequestParam("verifyCode") String verifyCode) {
		String code = (String) request.getSession().getAttribute("code");
		Map<String, String> resultMap = new HashMap<String, String>();

		if (Value.isEmpty(email)) {
			resultMap.put("error", "邮箱为空");
			return resultMap;
		}
		if (Value.isEmpty(verifyCode)) {
			resultMap.put("error", "验证码为空");
			return resultMap;
		}
		if (!verifyCode.equals(code)) {
			resultMap.put("error", "验证码错误");
			return resultMap;
		}

		String link = "localhost:8080/login/emailJoin?email=" + email + "&amp;code="+DigestUtil.md5(email);
		StringBuilder sb = new StringBuilder(4);
		sb.append("<html><body>");
		sb.append("<a href='").append(link).append("'>").append(link).append("</a>");
		sb.append("</body></html>");
		try {
			
			MailSendHelper.sendEmail(email, "注册邮件", sb.toString(), null);

			request.getSession().removeAttribute("code");
		} catch (Exception e) {
			resultMap.put("error", e.getMessage());
		}
		return resultMap;
	}

}
