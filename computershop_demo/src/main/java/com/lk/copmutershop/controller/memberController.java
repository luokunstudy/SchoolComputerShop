package com.lk.copmutershop.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.lk.copmutershop.bean.member;
import com.lk.copmutershop.dao.memberMapper;
import com.lk.copmutershop.service.memberservice;


/** 
* @author 作者 :luokun 
* @version 创建时间：2017年10月24日 下午5:35:42 
* 类说明 
*/
@Controller
@RequestMapping("/user")
//这里用了@SessionAttributes，可以直接把model中的user(也就key)放入其中
//这样保证了session中存在member这个对象
@SessionAttributes("member")
public class memberController {
    @Autowired
    memberservice memberservices;  
    
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	memberMapper mapper = ctx.getBean(memberMapper.class);

	
	  //注册会员
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String Savemember(member member){ 
    	
    //	memberservices.Savemember(member);  
    	mapper.insert(member);
    	System.out.println("会员信息："+member);
    	return "redirect:/login.jsp";
    	
    }
    //正常访问login页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
   //表单提交过来的路径
    @RequestMapping("/checkLogin")
    public String checkLogin(member member,Model model){
        //调用service方法
    	member = memberservices.checkLogin(member.getAccount(),member.getPassword());
        //若有user则添加到model里并且跳转到成功页面
        if(member != null){
            model.addAttribute("member",member.getAccount());
            System.out.println("addAttribute"+model.addAttribute("member",member.getAccount()));
            return "redirect:/NewFile.jsp";
        }
        return "fail";
    }    
	
}
