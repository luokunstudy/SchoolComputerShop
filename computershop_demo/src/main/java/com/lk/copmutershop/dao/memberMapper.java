package com.lk.copmutershop.dao;

import com.lk.copmutershop.bean.member;
import com.lk.copmutershop.bean.memberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface memberMapper {
    long countByExample(memberExample example);

    int deleteByExample(memberExample example);

    int deleteByPrimaryKey(String account);

    int insert(member record);

    int insertSelective(member record);

    List<member> selectByExample(memberExample example);

    member selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") member mrmber, @Param("example") memberExample example);

    int updateByExample(@Param("record") member record, @Param("example") memberExample example);

    int updateByPrimaryKeySelective(member record);
    //登录方法
    member findByaccount(String account);
    //修改个人信息
    boolean updateByPrimaryKey(member member);
}