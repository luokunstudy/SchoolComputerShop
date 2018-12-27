package com.lk.copmutershopbackstage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.computershopbackstage.dao.AdminMapper;
import com.lk.copmutershopbackstage.service.Adminservice;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年11月26日 下午7:57:05 
* 类说明 
*/
@Service
public class AdminserviceImpl implements Adminservice{
	@Autowired
	AdminMapper adminMapper;

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		adminMapper.findUserByNameAndPwd(username, password);
	}

}
