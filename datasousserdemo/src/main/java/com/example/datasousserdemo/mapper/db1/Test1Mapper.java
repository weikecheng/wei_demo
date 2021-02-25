package com.example.datasousserdemo.mapper.db1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface Test1Mapper{
    @Insert("INSERT INTO aaaa VALUES (#{aaa},#{bbb})")
    int add1(@Param("aaa") String aaa, @Param("bbb") String bbb);
}
