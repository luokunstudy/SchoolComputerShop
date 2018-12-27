package com.lk.copmutershop.dao;

import com.lk.copmutershop.bean.Goods_need;
import com.lk.copmutershop.bean.Goods_needExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Goods_needMapper {
    long countByExample(Goods_needExample example);

    int deleteByExample(Goods_needExample example);

    int deleteByPrimaryKey(Integer mseeageId);

    int insert(Goods_need record);

    int insertSelective(Goods_need record);

    List<Goods_need> selectByExample(Goods_needExample example);

    Goods_need selectByPrimaryKey(Integer mseeageId);

    int updateByExampleSelective(@Param("record") Goods_need record, @Param("example") Goods_needExample example);

    int updateByExample(@Param("record") Goods_need record, @Param("example") Goods_needExample example);

    int updateByPrimaryKeySelective(Goods_need record);

    int updateByPrimaryKey(Goods_need record);
}