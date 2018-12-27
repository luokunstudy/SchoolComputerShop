package com.lk.copmutershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lk.copmutershop.bean.Goods_type;
import com.lk.copmutershop.service.Goods_typeService;
import com.lk.copmutershop.utils.Msg;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年10月27日 上午8:33:46 
* 类说明 
*/
@Controller
public class Goods_typeController {
	@Autowired
   private  Goods_typeService goods_typeService;
	//返回所有商品类型
	@RequestMapping("/shop")
	@ResponseBody
	public Msg getshoptype(){
		List<Goods_type> list = goods_typeService.getshoptype();
		return Msg.success().add("shop", list);
		
	}
	
}
