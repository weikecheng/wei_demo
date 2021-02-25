package com.example.datasousserdemo.mapper.db2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Test2Mapper{
    @Insert("INSERT INTO aaaa VALUES (#{aaa},#{bbb})")
    int add2(@Param("aaa") String aaa, @Param("bbb") String bbb);
}
