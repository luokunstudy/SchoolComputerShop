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
import com.lk.computershopbackstage.bean.Goods_need;
import com.lk.copmutershopbackstage.service.QueryShopneedinfoService;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月5日 上午9:59:42 
* 类说明 
*/
@Controller
@RequestMapping("shopneedmessage")
public class backstageshopneedinfoController {
	@Autowired
	QueryShopneedinfoService queryShopneedinfoService;

	//查询所有商品需求信息
		@RequestMapping("/Queryallshopneedinfo")
		public String Queryallshopneedinfo(@RequestParam(value="pn",defaultValue="1")Integer pn,Goods_need goodsneed,HttpServletRequest request,Model model ){
			//每页5条	
			PageHelper.startPage(pn, 8);
			List<Goods_need> listshopneedinfo =queryShopneedinfoService.selectByExample(null);
			//连续连续显示页码(1,2,3,4)
			PageInfo pageInfo =new PageInfo(listshopneedinfo,4);
			model.addAttribute("pageInfo",pageInfo);
			return "listshopneedinfo";	
		}
	//按商品需求信息编号查
		@RequestMapping("/QueryshopneedinfoId")
		public String QueryshopneedinfoId(@RequestParam(value="pn",defaultValue="1")Integer pn,Integer mseeageId,HttpServletRequest request,Model model){
			PageHelper.startPage(pn, 8);
			List<Goods_need> listshopneedinfiId = queryShopneedinfoService.selectByPrimaryKey(mseeageId);
			//连续连续显示页码(1,2,3,4)
			PageInfo pageInfo =new PageInfo(listshopneedinfiId,4);
			model.addAttribute("pageInfo",pageInfo);
			return "listshopneedinfo";	
		}
	//按商品需求信息发布者编号查
		@RequestMapping("/Queryshopeneedinfoaccount")
		public String Queryshopeneedinfoaccount(@RequestParam(value="pn",defaultValue="1")Integer pn,String account,HttpServletRequest request,Model model){
			PageHelper.startPage(pn, 8);
			List<Goods_need> listshopneedinfiaccount =  queryShopneedinfoService.selectaccount(account);
			PageInfo pageInfo =new PageInfo(listshopneedinfiaccount,4);
			model.addAttribute("pageInfo",pageInfo);
			return "listshopneedinfo";			
		}
	//按需求商品名称查	
		@RequestMapping("/Queryshopneedinfoname")
		public String Queryshopneedinfoname(@RequestParam(value="pn",defaultValue="1")Integer pn,String goodsName,HttpServletRequest request,Model model){
			PageHelper.startPage(pn, 8);
			List<Goods_need> listshopneedinfoname =queryShopneedinfoService.selectname(goodsName);	
			PageInfo pageInfo =new PageInfo(listshopneedinfoname,4);
			model.addAttribute("pageInfo",pageInfo);
			return "listshopneedinfo";		
		}
	//按商品需求信息编号删除
		@RequestMapping("/deleteshopneedinfo")
		public String Deleteshopneedinfo(@RequestParam(value="pn",defaultValue="1")Integer pn,Integer mseeageId,HttpServletRequest request,Model model,Goods_need goodsneed){
			queryShopneedinfoService.deleteByPrimaryKey(mseeageId);
			//每页5条	
			PageHelper.startPage(pn, 8);
			List<Goods_need> listshopneedinfo =queryShopneedinfoService.selectByExample(null);
			//连续连续显示页码(1,2,3,4)
			PageInfo pageInfo =new PageInfo(listshopneedinfo,4);
			model.addAttribute("pageInfo",pageInfo);
			return "listshopneedinfo";	
		}
		
}
