package com.lk.copmutershopbackstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.computershopbackstage.bean.member;
import com.lk.computershopbackstage.bean.memberExample;
import com.lk.computershopbackstage.dao.memberMapper;
import com.lk.copmutershopbackstage.service.Querymemberinfo;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月7日 上午11:07:47 
* 类说明 
*/
@Service
public class QuerymemberinfoImpl implements Querymemberinfo{
	@Autowired
    memberMapper memberMapper;
	
	@Override
	public List<member> selectByExample(memberExample example) {
		List<member> listallmemberinfo= memberMapper.selectByExample(null);
		return listallmemberinfo;
	}

	@Override
	public List<member> selectByPrimaryKey(String account) {
		List<member> listaccount =  memberMapper.selectByPrimaryKey(account);
		return listaccount;
	}

}
