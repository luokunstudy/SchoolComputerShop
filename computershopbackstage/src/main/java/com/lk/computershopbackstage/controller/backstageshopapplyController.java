package com.lk.computershopbackstage.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lk.computershopbackstage.bean.Apply;
import com.lk.computershopbackstage.bean.Goods_need;
import com.lk.computershopbackstage.utils.Msg;
import com.lk.copmutershopbackstage.service.Queryshopapplyinfoservice;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月5日 上午11:15:25 
* 类说明 
*/
@Controller
@RequestMapping("shopapplymessage")
public class backstageshopapplyController {
	  @Autowired
	  Queryshopapplyinfoservice queryshopapplyinfoservice;
	  
	// spring日期转换
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		}
	  
	  //查询所有申请信息
	  @RequestMapping("/Queryallapply")
	  public String Queryallapply(@RequestParam(value="pn",defaultValue="1")Integer pn,Apply apply,HttpServletRequest request,Model model ){
		//每页5条	
	   PageHelper.startPage(pn, 5);
	   List<Apply> listallapplyinfo = queryshopapplyinfoservice.selectByExample(null);
	   List<String> phone = new ArrayList<>();
		for (Apply apply1 : listallapplyinfo) {
			String str = apply1.getGoods().getGoodsPhone();
			String[] strs = str.split(",");
			apply1.getGoods().setGoodsPhone(strs[0]);
			phone.add(apply1.getGoods().getGoodsPhone());
		}
	  //连续连续显示页码(1,2,3,4)
		PageInfo pageInfo =new PageInfo(listallapplyinfo,4);
		model.addAttribute("pageInfo",pageInfo);
		return "listshopapplyinfo";  
	  }
	  //根据商品名称查询
	  @RequestMapping("/QueryapplygoodsName")
	  public String QueryapplygoodsName(@RequestParam(value="pn",defaultValue="1")Integer pn,String goodsName,
			  HttpServletRequest request,Model model,Apply apply){
		  PageHelper.startPage(pn, 5);
		  List<Apply> listapplygoodsName = queryshopapplyinfoservice.selectgoodsName(goodsName);
		  List<String> phone = new ArrayList<>();
		  for (Apply apply1 : listapplygoodsName) {
				String str = apply1.getGoods().getGoodsPhone();
				String[] strs = str.split(",");
				apply1.getGoods().setGoodsPhone(strs[0]);
				phone.add(apply1.getGoods().getGoodsPhone());
			}
		  //连续连续显示页码(1,2,3,4)
			PageInfo pageInfo =new PageInfo(listapplygoodsName,4);
			model.addAttribute("pageInfo",pageInfo);
			return "listshopapplyinfo";    
	  }
	  //根据商品Id删除
	  @RequestMapping("/deleteapply")
	  public String Deleteapply(@RequestParam(value="pn",defaultValue="1")Integer pn,Apply apply,Integer applyId,HttpServletRequest request,Model model){
	    queryshopapplyinfoservice.deleteByPrimaryKey(applyId);
		//每页5条	
		   PageHelper.startPage(pn, 5);
		   List<Apply> listallapplyinfo = queryshopapplyinfoservice.selectByExample(null);
		   List<String> phone = new ArrayList<>();
		   for (Apply apply1 : listallapplyinfo) {
				String str = apply1.getGoods().getGoodsPhone();
				String[] strs = str.split(",");
				apply1.getGoods().setGoodsPhone(strs[0]);
				phone.add(apply1.getGoods().getGoodsPhone());
			}
		  //连续连续显示页码(1,2,3,4)
			PageInfo pageInfo =new PageInfo(listallapplyinfo,4);
			model.addAttribute("pageInfo",pageInfo);
			return "listshopapplyinfo";  
	  }
	  //根据申请编号查询
	  @RequestMapping("/applyinfo") 
	  public String applyinfo(HttpServletRequest request,Integer applyId){
	//	System.out.println("applyId"+applyId);
		Apply listapplyinfo =  queryshopapplyinfoservice.selectByPrimaryKey(applyId);
		request.setAttribute("applyinfo", listapplyinfo);
	//	System.out.println("申请信息"+listapplyinfo);
		return "updateapply";	  
	  }
	//根据申请编号更新
	  @RequestMapping("/updatstaues") 
	  public String updatstaues(HttpServletRequest request,Integer applyId,Apply apply,
			  @RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		   queryshopapplyinfoservice.updateByPrimaryKey(apply);
		  //每页5条	
		   PageHelper.startPage(pn, 5);
		   List<Apply> listallapplyinfo = queryshopapplyinfoservice.selectByExample(null);
		   List<String> phone = new ArrayList<>();
		   for (Apply apply1 : listallapplyinfo) {
				String str = apply1.getGoods().getGoodsPhone();
				String[] strs = str.split(",");
				apply1.getGoods().setGoodsPhone(strs[0]);
				phone.add(apply1.getGoods().getGoodsPhone());
			}
		  //连续连续显示页码(1,2,3,4)
			PageInfo pageInfo =new PageInfo(listallapplyinfo,4);
			model.addAttribute("pageInfo",pageInfo);
			return "listshopapplyinfo";  	  
	  }
}
