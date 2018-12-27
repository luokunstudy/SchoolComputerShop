package com.lk.copmutershopbackstage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.computershopbackstage.bean.Goods_type;
import com.lk.computershopbackstage.bean.Goods_typeExample;
import com.lk.computershopbackstage.dao.Goods_typeMapper;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月10日 下午12:22:58 
* 类说明 
*/
@Service
public class GoodstypeServiceImpl implements GoodstypeService {
	@Autowired
	Goods_typeMapper goodsMpaper;

	@Override
	public int insert(Goods_type goodstype) {
		goodsMpaper.insert(goodstype);
		return 0;
	}

	@Override
	public List<Goods_type> selectByExample(Goods_typeExample example) {
		List<Goods_type> listalltype= goodsMpaper.selectByExample(null);
		return listalltype;
	}

	@Override
	public int deleteByPrimaryKey(Integer typeId) {
		goodsMpaper.deleteByPrimaryKey(typeId);
		return 0;
	}

}
