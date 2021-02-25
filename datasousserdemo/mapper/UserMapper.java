package com.example.datasousserdemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * 用户管理
 *      Mapper
 * @author yys
 */
public interface UserMapper {

    @Insert("INSERT INTO user VALUES (NULL, #{name}, #{age}, 1, NOW(), NOW())")
    int addUser(@Param("name") String name, @Param("age") Integer age);

}
