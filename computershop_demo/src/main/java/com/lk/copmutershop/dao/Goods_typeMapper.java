package com.lk.copmutershop.dao;

import com.lk.copmutershop.bean.Goods_type;
import com.lk.copmutershop.bean.Goods_typeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Goods_typeMapper {
    long countByExample(Goods_typeExample example);

    int deleteByExample(Goods_typeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(Goods_type record);

    int insertSelective(Goods_type record);

    List<Goods_type> selectByExample(Goods_typeExample example);

    Goods_type selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") Goods_type record, @Param("example") Goods_typeExample example);

    int updateByExample(@Param("record") Goods_type record, @Param("example") Goods_typeExample example);

    int updateByPrimaryKeySelective(Goods_type record);

    int updateByPrimaryKey(Goods_type record);
}