package com.lk.copmutershop.dao;

import com.lk.copmutershop.bean.Goods;
import com.lk.copmutershop.bean.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    //分类查电脑
    List<Goods> selectnewcomputer(String goodsCategory);    
    //分类查组件
    List<Goods> selectnewshop(@Param(value="goodsCategory")String goodsCategory,@Param(value="typeId")Integer typeId);
    //查询所有组件
    List<Goods> selectshop(Integer typeId);
    //模糊查询
    List<Goods> vagueselect(String goodsName);  
    //查询会员商上架的商品
    List<Goods> mygoods(String account);

}