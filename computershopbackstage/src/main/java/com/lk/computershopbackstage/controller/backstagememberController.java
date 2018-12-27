package com.lk.computershopbackstage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lk.computershopbackstage.bean.member;
import com.lk.copmutershopbackstage.service.Querymemberinfo;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月7日 上午11:04:55 
* 类说明 
*/
@Controller
@RequestMapping("member")
public class backstagememberController {
    @Autowired
	Querymemberinfo querymemberinfo;
    //查询所有会员信息
    @RequestMapping("queryallmember")
    public String queryallmember(@RequestParam(value="pn",defaultValue="1")Integer pn,member member,HttpServletRequest request,Model model){
    	//每页5条	
    	PageHelper.startPage(pn, 5);
    	List<member> listallmember = querymemberinfo.selectByExample(null);
    	//连续连续显示页码(1,2,3,4)
    	PageInfo pageInfo =new PageInfo(listallmember,4);
    	model.addAttribute("pageInfo",pageInfo);
      // request.setAttribute("listallshop", listallshop);
    	return "listallmember";
    }
   //按照会员账号查询
    @RequestMapping("queryaccount")
    public String queryaccount(@RequestParam(value="pn",defaultValue="1")Integer pn,String account,HttpServletRequest request,Model model){
    	PageHelper.startPage(pn, 5);
    	List<member> memberinfo = querymemberinfo.selectByPrimaryKey(account);
    	PageInfo pageInfo =new PageInfo(memberinfo,4);
    	model.addAttribute("pageInfo",pageInfo);
    	return "listallmember";
    }
}
