package com.lk.computershopbackstage.dao;

import com.lk.computershopbackstage.bean.Goods_need;
import com.lk.computershopbackstage.bean.Goods_needExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Goods_needMapper {
    long countByExample(Goods_needExample example);

    int deleteByExample(Goods_needExample example);

    int insert(Goods_need record);

    int insertSelective(Goods_need record);

    int updateByExampleSelective(@Param("record") Goods_need record, @Param("example") Goods_needExample example);

    int updateByExample(@Param("record") Goods_need record, @Param("example") Goods_needExample example);

    int updateByPrimaryKeySelective(Goods_need record);

    int updateByPrimaryKey(Goods_need record);
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