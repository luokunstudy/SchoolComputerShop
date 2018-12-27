package com.lk.computershopbackstage.dao;

import com.lk.computershopbackstage.bean.Goods;
import com.lk.computershopbackstage.bean.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int insert(Goods record);

    int insertSelective(Goods record);
 
    Goods selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    //查询所有商品
    List<Goods> selectByExample(GoodsExample example);
    //按编号搜素查询
    List<Goods> selectGoodsId(Integer goodsId);
    //按商家编号查询
    List<Goods> selectAccount(String account);
    //按商品名称查询
    List<Goods> selectGoodsName(String goodsName);
    //删除商品信息
    int deleteByPrimaryKey(Integer goodsId);
}