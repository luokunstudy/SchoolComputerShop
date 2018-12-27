package com.lk.copmutershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.copmutershop.bean.Goods_type;
import com.lk.copmutershop.dao.Goods_typeMapper;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年10月27日 上午8:39:03 
* 类说明 
*/
@Service
public class Goods_typeService {
	@Autowired
	private Goods_typeMapper goods_typeMapper;
	
	public List<Goods_type> getshoptype(){
		//查出所有商品类型
		List<Goods_type> list = goods_typeMapper.selectByExample(null);
		return list;
		
	}

}
