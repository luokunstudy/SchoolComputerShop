package com.lk.computershopbackstage.dao;

import com.lk.computershopbackstage.bean.Apply;
import com.lk.computershopbackstage.bean.ApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {
    long countByExample(ApplyExample example);

    int deleteByExample(ApplyExample example);

    int insert(Apply record);

    int insertSelective(Apply record);

    int updateByExampleSelective(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByExample(@Param("record") Apply record, @Param("example") ApplyExample example);

   
    //查询所有商品信息
    List<Apply> selectByExample(ApplyExample example);
    //按商品类型查询
    List<Apply> selectgoodsName(String goodsName);
    //按编号删除
    int deleteByPrimaryKey(Integer applyId);
   //根据申请编号查询
    Apply selectByPrimaryKey(Integer applyId);
    int updateByPrimaryKeySelective(Apply apply);
    //根据申请编号更新
    int updateByPrimaryKey(Apply apply);
}