package com.qjk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qjk.data.User;
import com.qjk.form.LoginForm;
import com.qjk.service.IUserService;
import com.qjk.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	private IUserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	
	public String login(HttpServletRequest request,@ModelAttribute("loginForm") LoginForm loginForm) {
		loginForm.setAccount("");
		loginForm.setPassword("");
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			return "redirect:/";
		}
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, params = {
			"account", "password" })
	public String login(LoginForm loginForm,Model model,HttpServletRequest request) {

		try{
			User user = userService.login(loginForm.getAccount(), loginForm.getPassword());
			request.getSession().setAttribute("user",user);
			
		}catch(Exception e){
			model.addAttribute("error",e.getMessage());
			
			return "login/login";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "redirect:/";
	}

}
