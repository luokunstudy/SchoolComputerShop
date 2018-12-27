package com.lk.computershopbackstage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lk.computershopbackstage.bean.Goods;
import com.lk.computershopbackstage.bean.Goods_need;
import com.lk.copmutershopbackstage.service.QueryShopService;
import com.lk.copmutershopbackstage.service.QueryShopneedinfoService;

import net.sf.jsqlparser.statement.delete.Delete;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月3日 下午6:55:15 
* 类说明 
*/
@Controller
@RequestMapping("backstage")
public class backstageshopController {
	@Autowired
    QueryShopService queryShopService;
	//查询所有商品
	@RequestMapping("/Queryallshop")
	public String Queryallshop(@RequestParam(value="pn",defaultValue="1")Integer pn,Goods goods,HttpServletRequest request,Model model ) {
	//查询所有商品:分页、分割图片、时间显示格式、链表查询查类型名、搜索查询
	//每页5条	
	PageHelper.startPage(pn, 5);
	List<Goods>	listallshop=queryShopService.selectByExample(null);
	List<String> phone = new ArrayList<>();
	for (Goods goods2 : listallshop) {
	  //  System.out.println("商品类型信息"+goods2.getGoods_type().getGoodsType());	
		String str = goods2.getGoodsPhone();
		String[] strs = str.split(",");
		goods2.setGoodsPhone(strs[0]);
		phone.add(goods2.getGoodsPhone());
	}
	//连续连续显示页码(1,2,3,4)
	PageInfo pageInfo =new PageInfo(listallshop,4);
	model.addAttribute("pageInfo",pageInfo);
  // request.setAttribute("listallshop", listallshop);
		return "listallshop";
	}
	
	//按编号搜素查询
	@RequestMapping("/QueryGoodsId")
	public String QueryGoodsId(@RequestParam(value="pn",defaultValue="1")Integer pn,Integer goodsId,HttpServletRequest request,Model model){
		PageHelper.startPage(pn, 5);
		List<Goods> listgoodsId = queryShopService.selectGoodsId(goodsId);
		List<String> phone = new ArrayList<>();
		for (Goods goods2 : listgoodsId) {
		  //  System.out.println("商品类型信息"+goods2.getGoods_type().getGoodsType());	
			String str = goods2.getGoodsPhone();
			String[] strs = str.split(",");
			goods2.setGoodsPhone(strs[0]);
			phone.add(goods2.getGoodsPhone());
		}
		PageInfo pageInfo =new PageInfo(listgoodsId,4);
		model.addAttribute("pageInfo",pageInfo);
		return "listallshop";
	}
	
	//按商家编号搜素查询
	@RequestMapping("/QueryAccount")
	public String QueryAccount(@RequestParam(value="pn",defaultValue="1")Integer pn,String account,HttpServletRequest request,Model model){
		PageHelper.startPage(pn, 5);
		List<Goods> listaccount = queryShopService.selectAccount(account);
		List<String> phone = new ArrayList<>();
		for (Goods goods2 : listaccount) {	
			String str = goods2.getGoodsPhone();
			String[] strs = str.split(",");
			goods2.setGoodsPhone(strs[0]);
			phone.add(goods2.getGoodsPhone());
		}
		PageInfo pageInfo =new PageInfo(listaccount,4);
		model.addAttribute("pageInfo",pageInfo);
		return "listallshop";	
	}	
	//按商品名称查询
	@RequestMapping("/QuerygoodsName")
	public String QuerygoodsName(@RequestParam(value="pn",defaultValue="1")Integer pn,String goodsName,HttpServletRequest request,Model model){
		PageHelper.startPage(pn, 5);
		List<Goods> listgoodsName = queryShopService.selectGoodsName(goodsName);
		List<String> phone = new ArrayList<>();
		for (Goods goods2 : listgoodsName) {	
			String str = goods2.getGoodsPhone();
			String[] strs = str.split(",");
			goods2.setGoodsPhone(strs[0]);
			phone.add(goods2.getGoodsPhone());
		}
		PageInfo pageInfo =new PageInfo(listgoodsName,4);
		model.addAttribute("pageInfo",pageInfo);
		return "listallshop";	
	}
	//删除商品信息
	@RequestMapping("/deleteshop")
	public String deleteshop(Integer goodsId,@RequestParam(value="pn",defaultValue="1")Integer pn,Goods goods,HttpServletRequest request,Model model){
		System.out.println("传入删除Id"+goodsId);
		queryShopService.deleteByPrimaryKey(goodsId);
		PageHelper.startPage(pn, 5);
		List<Goods>	listallshop=queryShopService.selectByExample(null);
		List<String> phone = new ArrayList<>();
		for (Goods goods2 : listallshop) {
		  //  System.out.println("商品类型信息"+goods2.getGoods_type().getGoodsType());	
			String str = goods2.getGoodsPhone();
			String[] strs = str.split(",");
			goods2.setGoodsPhone(strs[0]);
			phone.add(goods2.getGoodsPhone());
		}
		//连续连续显示页码(1,2,3,4)
		PageInfo pageInfo =new PageInfo(listallshop,4);
		model.addAttribute("pageInfo",pageInfo);
		return "listallshop";	
	}

	
  
}
