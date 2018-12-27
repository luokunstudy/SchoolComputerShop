package com.lk.copmutershopbackstage.service;

import java.util.List;

import com.lk.computershopbackstage.bean.Goods_need;
import com.lk.computershopbackstage.bean.Goods_needExample;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月5日 上午9:41:25 
* 类说明 
*/
public interface QueryShopneedinfoService {
    //查询所有商品需求信息
	List<Goods_need> selectByExample(Goods_needExample example);
    //按商品需求信息编号查
	List<Goods_need> selectByPrimaryKey(Integer mseeageId);
	//按商品需求信息发布者编号查
	List<Goods_need> selectaccount(String  account);
	//按需求商品名称查	
    List<Goods_need> selectname(String  goodsName);
    //按商品需求信息编号删除
    int deleteByPrimaryKey(Integer mseeageId);
}
