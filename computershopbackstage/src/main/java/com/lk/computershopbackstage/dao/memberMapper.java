package com.lk.computershopbackstage.dao;

import com.lk.computershopbackstage.bean.member;
import com.lk.computershopbackstage.bean.memberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.object.MappingSqlQueryWithParameters;

public interface memberMapper {
    long countByExample(memberExample example);

    int deleteByExample(memberExample example);

    int deleteByPrimaryKey(String account);

    int insert(member record);

    int insertSelective(member record);

    int updateByExampleSelective(@Param("record") member record, @Param("example") memberExample example);

    int updateByExample(@Param("record") member record, @Param("example") memberExample example);

    int updateByPrimaryKeySelective(member record);

    int updateByPrimaryKey(member record);
    
    //查询所有会员信息
    List<member> selectByExample(memberExample example);
    //按照会员账号查询
    List<member> selectByPrimaryKey(String account);
}