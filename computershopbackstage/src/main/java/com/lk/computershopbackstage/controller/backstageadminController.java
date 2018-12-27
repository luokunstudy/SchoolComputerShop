package com.lk.computershopbackstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lk.copmutershopbackstage.service.Adminservice;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年11月27日 上午8:57:25 
* 类说明 
*/
@Controller
@SessionAttributes("msg")
@RequestMapping("backstage")
public class backstageadminController {	
	@Autowired
	Adminservice adminservice;	
	//管理员登录
		@RequestMapping("/adminLogin")
		public String adminLogin(String username,String password,Model model){
			adminservice.login(username, password);
			model.addAttribute("msg", "登录成功");
			model.addAttribute("msg", username);
			System.out.println(model.addAttribute("msg", username));
			return "redirect:/index.jsp";
		/*	if(username.equals("admix") && password.equals("123456")){
				return "redirect:/index.jsp";
				return "success";
			}
			return "fail";*/
		}
}
