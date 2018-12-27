package com.lk.copmutershopbackstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.computershopbackstage.bean.Apply;
import com.lk.computershopbackstage.bean.ApplyExample;
import com.lk.computershopbackstage.dao.ApplyMapper;
import com.lk.copmutershopbackstage.service.Queryshopapplyinfoservice;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月5日 上午11:20:10 
* 类说明 
*/
@Service
public class QueryshopapplyinfoserviceImpl implements Queryshopapplyinfoservice{
	@Autowired
    ApplyMapper applyMapper;
	@Override
	public List<Apply> selectByExample(ApplyExample example) {
        List<Apply> listallapply = applyMapper.selectByExample(example);
		return listallapply;
	}
	@Override
	public List<Apply> selectgoodsName(String goodsName) {
		List<Apply> listapplygoodsName =  applyMapper.selectgoodsName(goodsName);
		return listapplygoodsName;
	}
	@Override
	public int deleteByPrimaryKey(Integer applyId) {
		applyMapper.deleteByPrimaryKey(applyId);
		return 0;
	}
	@Override
	public Apply selectByPrimaryKey(Integer applyId) {
	 Apply applyinfo = 	applyMapper.selectByPrimaryKey(applyId);
		return applyinfo;
	}
	
	@Override
	public int updateByPrimaryKey(Apply apply) {
		applyMapper.updateByPrimaryKey(apply);
		return 0;
	}
	

}
