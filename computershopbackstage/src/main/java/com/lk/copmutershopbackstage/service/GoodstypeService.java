package com.lk.copmutershopbackstage.service;

import java.util.List;

import com.lk.computershopbackstage.bean.Goods_type;
import com.lk.computershopbackstage.bean.Goods_typeExample;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月10日 下午12:22:47 
* 类说明 
*/
public interface GoodstypeService {
	//添加商品类型
	int insert(Goods_type goodstype);
    //查询所有类型
    List<Goods_type> selectByExample(Goods_typeExample example);
    //根据商品类型id删除
    int deleteByPrimaryKey(Integer typeId);

}
