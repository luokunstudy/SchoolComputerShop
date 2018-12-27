package com.lk.copmutershop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lk.copmutershop.bean.Goods_need;
import com.lk.copmutershop.dao.Goods_needMapper;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年11月4日 上午11:42:27 
* 类说明 
*/
@Controller
@RequestMapping("/shop")
public class ComputerneedController {
  
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	Goods_needMapper mapper = ctx.getBean(Goods_needMapper.class);
	//发布商品需求信息
	@RequestMapping(value="/needmessage",method=RequestMethod.POST)
	public String shopneedmessage(Goods_need goods_need){
		mapper.insert(goods_need);
		return "success";
		
	}
	//spring日期转换
		@InitBinder  
		public void initBinder(WebDataBinder binder) {  
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		    dateFormat.setLenient(false);  
		    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		}
}
