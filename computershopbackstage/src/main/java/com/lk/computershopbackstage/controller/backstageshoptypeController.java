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
import com.lk.computershopbackstage.bean.Goods_type;
import com.lk.copmutershopbackstage.service.GoodstypeService;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月10日 下午12:21:56 
* 类说明 
*/


@Controller
@RequestMapping("goodstype")
public class backstageshoptypeController {
    @Autowired
	GoodstypeService goodstypeService;
    //添加商品类型
    @RequestMapping("/addshoptype")
    public String addshoptype(Goods_type goodstype){
    	goodstypeService.insert(goodstype);
		return "success";
    }
    @RequestMapping("/qureryalltype")
    public String Qureryalltype(@RequestParam(value="pn",defaultValue="1")Integer pn,Goods_type goodstype,HttpServletRequest request,Model model ){
    	PageHelper.startPage(pn, 5);
    	List<Goods_type> listalltype = goodstypeService.selectByExample(null);
    	PageInfo pageInfo = new PageInfo(listalltype, 4);
		model.addAttribute("pageInfo", pageInfo);
    	return "listallgoodstype";
    }
    //根据商品类型id删除
    @RequestMapping("/deleteshoptype")
    public String Deleteshoptype(@RequestParam(value="pn",defaultValue="1")Integer pn,Goods_type goodstype,
    		HttpServletRequest request,Model model,Integer typeId){
    	goodstypeService.deleteByPrimaryKey(typeId);
    	PageHelper.startPage(pn, 5);
    	List<Goods_type> listalltype = goodstypeService.selectByExample(null);
    	PageInfo pageInfo = new PageInfo(listalltype, 4);
		model.addAttribute("pageInfo", pageInfo);
    	return "listallgoodstype";
    	
    }
}
