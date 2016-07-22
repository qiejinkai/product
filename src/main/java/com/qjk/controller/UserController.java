package com.qjk.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qjk.data.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	Map<String,User> list = new HashMap<String,User>();

	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String users(Model model){
		
//		for (int i = 0; i < 4; i++) {
//			User user = new User();
//			user.setNick("zs"+i);
//			user.setPhone("13051701098");
//			user.setObjectId(i);
//			user.setEmail("qiejinkai@126.com");
//			list.add(user);
//		}
		
//		System.out.println("METHOD users");
		model.addAttribute("users", list);
		
		return "user/users";
	} 
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("user") User user){
		
		return "user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated User user,BindingResult result){
		if(result.hasErrors()){
			return "user/add";
		}
		list.put(user.getPhone(),user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="{phone}",method=RequestMethod.GET)
	public String show(@PathVariable String phone,Model model){
		model.addAttribute(list.get(phone));
		return "user/show";
	}
	
	@RequestMapping(value="{phone}/update",method=RequestMethod.GET)
	public String update(@PathVariable String phone,Model model){
		
		model.addAttribute(list.get(phone));
		
		return "user/update";
	}
	
	@RequestMapping(value="{phone}/update",method=RequestMethod.POST)
	public String update(@PathVariable String phone ,@Validated User user,BindingResult result){
		if(result.hasErrors()){
			return "user/update";
			
		}
		list.put(phone, user);
		
		return "redirect:user/users";
	}
	
	@RequestMapping(value="{phone}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable String phone){
		list.remove(phone);
		return "redirect:user/users";
	}
}
