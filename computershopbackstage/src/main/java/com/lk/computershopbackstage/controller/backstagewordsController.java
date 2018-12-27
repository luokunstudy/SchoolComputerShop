package com.lk.computershopbackstage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lk.computershopbackstage.bean.Words;
import com.lk.copmutershopbackstage.service.QueryWordsService;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月7日 下午9:16:46 
* 类说明 
*/
@Controller
@RequestMapping("Words")
public class backstagewordsController {
    @Autowired
	QueryWordsService queryWordsService;
    
    @RequestMapping("/Queryallwords")
    public String Queryallwords(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Words words,
			HttpServletRequest request, Model model){
    	
         	PageHelper.startPage(pn, 5);
         	List<Words> listallWords = queryWordsService.selectByExample(null);
            // 连续连续显示页码(1,2,3,4)
    		PageInfo pageInfo = new PageInfo(listallWords, 4);
    		model.addAttribute("pageInfo", pageInfo);
    		// request.setAttribute("listallshop", listallshop);
    		return "listallwords";
    }
    @RequestMapping("/QuerywordsgoodsId")
    public String QuerywordsgoodsId(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Integer goodsId,
			HttpServletRequest request, Model model){
    	    PageHelper.startPage(pn, 5);
    	    List<Words> listgoodsId = queryWordsService.selectwordsgoodsId(goodsId);
    	    // 连续连续显示页码(1,2,3,4)
    		PageInfo pageInfo = new PageInfo(listgoodsId, 4);
    		model.addAttribute("pageInfo", pageInfo);
    		// request.setAttribute("listallshop", listallshop);
    		return "listallwords";
    	
    }
    @RequestMapping("/deletewords")
    public String Deletewords(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Words words,
			HttpServletRequest request, Model model,Integer wordsId){
    	    queryWordsService.deleteByPrimaryKey(wordsId);
    	    PageHelper.startPage(pn, 5);
         	List<Words> listallWords = queryWordsService.selectByExample(null);
            // 连续连续显示页码(1,2,3,4)
    		PageInfo pageInfo = new PageInfo(listallWords, 4);
    		model.addAttribute("pageInfo", pageInfo);
    		// request.setAttribute("listallshop", listallshop);
    		return "listallwords";	
    }
}
