package com.lk.copmutershopbackstage.service;

import java.util.List;

import com.lk.computershopbackstage.bean.member;
import com.lk.computershopbackstage.bean.memberExample;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月7日 上午11:07:22 
* 类说明 
*/
public interface Querymemberinfo {
    //查询所有会员信息
    List<member> selectByExample(memberExample example);
    //按照会员账号查询
    List<member> selectByPrimaryKey(String account);
}
