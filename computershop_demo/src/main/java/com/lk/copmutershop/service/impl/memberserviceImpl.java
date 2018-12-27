package com.lk.copmutershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.copmutershop.bean.member;
import com.lk.copmutershop.bean.memberExample;
import com.lk.copmutershop.dao.memberMapper;
import com.lk.copmutershop.service.memberservice;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年10月25日 上午9:53:29 
* 类说明 
*/
@Service
public class memberserviceImpl implements memberservice{
   @Autowired
	memberMapper memberMapper;
   /* 
    * 检验用户登录业务
    * 
    */
   public member checkLogin(String account, String password) {

       member member = memberMapper.findByaccount(account);
       if(member != null && member.getPassword().equals(password)){

           return member;
       }
       return null;
   }
   @Override
   public boolean updateByPrimaryKey(member member) {
   	System.out.println("service中："+ member);
   	return memberMapper.updateByPrimaryKey(member);
   }
@Override
public int updateByPrimaryKeySelective(member member) {
	memberMapper.updateByPrimaryKeySelective(member);
	return 0;
}



}
