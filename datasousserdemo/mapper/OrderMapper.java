package com.example.datasousserdemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * 订单管理
 *      Mapper
 * @author yys
 */
public interface OrderMapper {

    // order为数据库关键字，记得使用``
    @Insert("INSERT INTO `order` VALUES (NULL, #{amount}, #{address}, 1, NOW(), NOW())")
    int addOrder(@Param("amount") Double amount, @Param("address") String address);

}