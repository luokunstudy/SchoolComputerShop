package com.lk.copmutershop.service;

import org.apache.ibatis.annotations.Param;

import com.lk.copmutershop.bean.member;
import com.lk.copmutershop.bean.memberExample;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年10月25日 上午9:52:32 
* 类说明 
*/
public interface memberservice {

	//检验用户登录
     member checkLogin(String account,String password);
     //修改个人信息
     boolean updateByPrimaryKey(member member);
     
     int updateByPrimaryKeySelective(member record);
}
