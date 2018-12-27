package com.lk.copmutershopbackstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.computershopbackstage.bean.Goods_need;
import com.lk.computershopbackstage.bean.Goods_needExample;
import com.lk.computershopbackstage.dao.Goods_needMapper;
import com.lk.copmutershopbackstage.service.QueryShopneedinfoService;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月5日 上午9:43:04 
* 类说明 
*/
@Service
public class QueryShopneedinfoServiceImpl implements QueryShopneedinfoService{
	@Autowired
	Goods_needMapper goodsneedMapper;

	@Override
	public List<Goods_need> selectByExample(Goods_needExample example) {
        List<Goods_need> listallshopinfo = goodsneedMapper.selectByExample(null);
		return listallshopinfo;
	}

	@Override
	public List<Goods_need> selectByPrimaryKey(Integer mseeageId) {
		List<Goods_need> listshopneedinfoId = goodsneedMapper.selectByPrimaryKey(mseeageId);
		return listshopneedinfoId;
	}

	@Override
	public List<Goods_need> selectaccount(String account) {
		List<Goods_need> listshopneedinfoaccount = goodsneedMapper.selectaccount(account);
		return listshopneedinfoaccount;
	}

	@Override
	public List<Goods_need> selectname(String goodsName) {
		List<Goods_need> listshopneedinfoname =	goodsneedMapper.selectname(goodsName);
		return listshopneedinfoname;
	}

	@Override
	public int deleteByPrimaryKey(Integer mseeageId) {
		goodsneedMapper.deleteByPrimaryKey(mseeageId);
		return 0;
	}

}
