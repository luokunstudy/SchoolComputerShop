package com.lk.computershopbackstage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lk.computershopbackstage.bean.Notice;
import com.lk.computershopbackstage.bean.Words;
import com.lk.computershopbackstage.bean.member;
import com.lk.copmutershopbackstage.service.NoticeService;

/**
 * @author 作者 :luokun
 * @version 创建时间：2017年12月7日 下午7:30:04 类说明
 */
@Controller
@RequestMapping("notice")
public class backstageNoticeController {
	@Autowired
	NoticeService noticeService;

	// spring日期转换
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// 发布公告
	@RequestMapping("/addwords")
	public String addwords(Notice notice) {
		noticeService.insert(notice);
		return "success";
	}

	// 查看公告
	@RequestMapping("/Queryallnotice")
	public String Queryallnotice(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Notice notice,
			HttpServletRequest request, Model model) {
		PageHelper.startPage(pn, 5);
		List<Notice> listallnotice = noticeService.selectByExample(null);
		// 连续连续显示页码(1,2,3,4)
		PageInfo pageInfo = new PageInfo(listallnotice, 4);
		model.addAttribute("pageInfo", pageInfo);
		// request.setAttribute("listallshop", listallshop);
		return "listallnotice";
	}

	// 按时间查询
	@RequestMapping("/wordsTime")
	public String Querynoticetime(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Date wordsTime,
			HttpServletRequest request, Model model) {
		PageHelper.startPage(pn, 5);
		List<Notice> listnoticetime = noticeService.selectnoticetime(wordsTime);
		// 连续连续显示页码(1,2,3,4)
		PageInfo pageInfo = new PageInfo(listnoticetime, 4);
		model.addAttribute("pageInfo", pageInfo);
		// request.setAttribute("listallshop", listallshop);
		return "listallnotice";
	}
	//按标题查询
	@RequestMapping("/Querynoticetitle")
	public String Querynoticetitle(@RequestParam(value = "pn", defaultValue = "1") Integer pn, String wordsTitle,HttpServletRequest request, Model model){
		PageHelper.startPage(pn, 5);
		List<Notice> listnoticetitle=	noticeService.selectnoticetitle(wordsTitle);
		// 连续连续显示页码(1,2,3,4)
		PageInfo pageInfo = new PageInfo(listnoticetitle, 4);
		model.addAttribute("pageInfo", pageInfo);
		return "listallnotice";	
	}
   //删除公告
	@RequestMapping("/Deletenotice")
	public String Deletenotice(Integer noticeId,@RequestParam(value = "pn", defaultValue = "1") Integer pn, Notice notice,
			HttpServletRequest request, Model model){
		noticeService.deleteByPrimaryKey(noticeId);
		PageHelper.startPage(pn, 5);
		List<Notice> listallnotice = noticeService.selectByExample(null);
		// 连续连续显示页码(1,2,3,4)
		PageInfo pageInfo = new PageInfo(listallnotice, 4);
		model.addAttribute("pageInfo", pageInfo);
		// request.setAttribute("listallshop", listallshop);
		return "listallnotice";
		
	}
	
}
