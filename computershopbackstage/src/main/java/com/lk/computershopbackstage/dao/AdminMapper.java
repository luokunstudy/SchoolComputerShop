package com.lk.computershopbackstage.dao;

import com.lk.computershopbackstage.bean.Admin;
import com.lk.computershopbackstage.bean.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(String username);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    //根据用户名和密码查询用户  
    //注解的两个参数会自动封装成map集合，括号内即为键  
    public void findUserByNameAndPwd(@Param("username")String name, @Param("password")String password);  
}