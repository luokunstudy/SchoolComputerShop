package com.lk.copmutershop.dao;

import com.lk.copmutershop.bean.Orders;
import com.lk.copmutershop.bean.OrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    //查询会员订单
    Orders selectorder(String accountId);
    //查询会员销售订单
    List<Orders> querysaleorder(String account);
    //查询会员购买订单
    List<Orders> querybuyorder(String accountId);
    
}