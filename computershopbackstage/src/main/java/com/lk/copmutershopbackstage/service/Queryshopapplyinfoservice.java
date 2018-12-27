package com.lk.copmutershopbackstage.service;

import java.util.List;

import com.lk.computershopbackstage.bean.Apply;
import com.lk.computershopbackstage.bean.ApplyExample;

/** 
* @author 作者 :luokun 
* @version 创建时间：2017年12月5日 上午11:18:50 
* 类说明 
*/
public interface Queryshopapplyinfoservice {
    //查询所有商品信息
    List<Apply> selectByExample(ApplyExample example);
    //按商品类型查询
    List<Apply> selectgoodsName(String goodsName);
    //按编号删除
    int deleteByPrimaryKey(Integer applyId);
    //根据申请编号查询
    Apply selectByPrimaryKey(Integer applyId);
    //根据申请编号更新
    int updateByPrimaryKey(Apply apply);

}
