package com.lk.copmutershopbackstage.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.computershopbackstage.bean.Goods;
import com.lk.computershopbackstage.bean.GoodsExample;
import com.lk.computershopbackstage.bean.Goods_type;
import com.lk.computershopbackstage.dao.GoodsMapper;
import com.lk.computershopbackstage.dao.Goods_typeMapper;
import com.lk.copmutershopbackstage.service.QueryShopService;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月3日 下午6:59:14 
* 类说明 
*/
@Service
public class QueryShopServiceImpl implements QueryShopService{
	@Autowired
     GoodsMapper goodsMapper;
	@Override
	public List<Goods> selectByExample(GoodsExample example) {
	List<Goods> listshop =	goodsMapper.selectByExample(null);
		return listshop;
	}
	@Override
	public List<Goods> selectGoodsId(Integer goodsId) {
		List<Goods> listgoodsId = goodsMapper.selectGoodsId(goodsId);
		return listgoodsId;
	}
	@Override
	public List<Goods> selectAccount(String account) {
		List<Goods> listgoodstype= goodsMapper.selectAccount(account);
		return listgoodstype;
	}
	@Override
	public List<Goods> selectGoodsName(String goodsName) {
		List<Goods> listgoodsName = goodsMapper.selectGoodsName(goodsName);
		return listgoodsName;
	}
	@Override
	public int deleteByPrimaryKey(Integer goodsId) {
		goodsMapper.deleteByPrimaryKey(goodsId);
		return 0;
	}

	

}
