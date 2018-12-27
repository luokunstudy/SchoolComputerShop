package com.lk.copmutershop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lk.copmutershop.bean.Goods;
import com.lk.copmutershop.dao.GoodsMapper;

/**
 * @author 作者 :luokun
 * @version 创建时间：2017年10月26日 上午10:34:41 类说明
 */
@Controller
@RequestMapping("/computer")
public class GoodsController {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	GoodsMapper goodsMapper = ctx.getBean(GoodsMapper.class);
	// 上架商品
	@RequestMapping(value = "/sale", method = RequestMethod.POST)
	public String Sale(Goods goods,HttpSession httpSession) {
		/*String filename = goods.getGoodsPhone();
		String [] strs=filename.split(",");
		for (int i = 0; i < strs.length; i++) {
		//	System.out.println(strs[i]); 
		//	String fName = goods.getAccount() +"_"+ strs[i];

		}
		String fName = goods.getAccount() +"_"+ strs[0];
		String fName2 = goods.getAccount() +"_"+ strs[1];
		String newName =fName+","+fName2;
		System.out.println("newName:"+newName);*/
		// 文件重命名
	/*	String fName = "";
		String suffix = "";
		if (filename.indexOf(".") >= 0) {
			int indexdot = filename.indexOf(".");
			suffix = filename.substring(indexdot);
			fName = filename.substring(0, filename.lastIndexOf("."));
			//		Date now = new Date();
			//		fName = fName + "_" + now.getTime();
			fName = fName + "_" + goods.getAccount();
			fName = fName + suffix;
		}
		*/	
	//	httpSession.getAttribute("fName");
	//	httpSession.setAttribute("fNames", goods.getAccount());
	//	goods.setGoodsPhone(newName);		
		goodsMapper.insert(goods);	
		System.out.println("存入数据库图片名称"+goods.getGoodsPhone());
	//	System.out.println("商品信息：" + goods);
		return "successissue";

	}

	// spring日期转换
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	/**
	 * 文件上传功能
	 * 
	 * @param file
	 * @return
	 * @throws IOExcepti	on
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam("goodsPhone") CommonsMultipartFile[] goodsPhone,  
			HttpServletRequest request,HttpSession httpSession) throws IOException {
//	public String upload(MultipartFile goodsPhone, HttpServletRequest request,HttpSession httpSession) throws IOException {
	for(CommonsMultipartFile commonsMultipartFile:goodsPhone){
			try {
				File file = new File(request.getServletContext().getRealPath("/upload"),
			//	File file = new File("http://localhost:8080/computershop_demo",
						
			    //System.currentTimeMillis()获取当前时间
		//		System.currentTimeMillis() + "_"+commonsMultipartFile.getOriginalFilename());
				commonsMultipartFile.getOriginalFilename());
				System.out.println("路径："+file.getPath()+"");
				System.out.println("图片名称"+file.getName());
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(commonsMultipartFile.getBytes());
				fileOutputStream.close();
			} catch (Exception e) {
				 e.printStackTrace();
			}
			
		}
		 return "ok";
		/*
	//	httpSession.setAttribute("fName", fName);

		*/
	}

}
