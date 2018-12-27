package com.lk.computershopbackstage.dao;

import com.lk.computershopbackstage.bean.Goods;
import com.lk.computershopbackstage.bean.Goods_type;
import com.lk.computershopbackstage.bean.Goods_typeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Goods_typeMapper {
    long countByExample(Goods_typeExample example);

    int deleteByExample(Goods_typeExample example);
    
    int insertSelective(Goods_type record);

    

    Goods_type selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") Goods_type record, @Param("example") Goods_typeExample example);

    int updateByExample(@Param("record") Goods_type record, @Param("example") Goods_typeExample example);

    int updateByPrimaryKeySelective(Goods_type record);

    int updateByPrimaryKey(Goods_type record);
    //添加类型
    int insert(Goods_type goodstype);
    //查询所有类型
    List<Goods_type> selectByExample(Goods_typeExample example);
  //根据商品类型id删除
    int deleteByPrimaryKey(Integer typeId);
}