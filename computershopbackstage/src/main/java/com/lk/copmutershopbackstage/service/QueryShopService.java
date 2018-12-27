package com.lk.copmutershopbackstage.service;

import java.util.List;


import com.lk.computershopbackstage.bean.Goods;
import com.lk.computershopbackstage.bean.GoodsExample;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月3日 下午6:57:45 
* 类说明 
*/
public interface QueryShopService {
	//查询所有商品
    List<Goods> selectByExample(GoodsExample example);  
    //按编号搜素查询
    List<Goods> selectGoodsId(Integer goodsId);
    //按商家编号
    List<Goods> selectAccount(String account);
    //按商品名称查询
    List<Goods> selectGoodsName(String goodsName);
  //删除商品信息
    int deleteByPrimaryKey(Integer goodsId);
}
