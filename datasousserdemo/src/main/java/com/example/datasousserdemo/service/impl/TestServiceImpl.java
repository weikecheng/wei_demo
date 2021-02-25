package com.example.datasousserdemo.service.impl;

import com.example.datasousserdemo.mapper.db1.Test1Mapper;
import com.example.datasousserdemo.mapper.db2.Test2Mapper;
import com.example.datasousserdemo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version V1.0.0
 * @ProjectName: springcloud-book-master
 * @ClassName: TestServiceImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: weikecheng
 * @Date: 2021/2/3 16:44
 */
@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    private Test1Mapper test1Mapper;
    @Autowired
    private Test2Mapper test2Mapper;
    @Override
    public void add1() {
        test1Mapper.add1("12345","456");
    }

    @Override
    public void add2() {
        test2Mapper.add2("4567","789");
    }

	@Override
	public void test() {
		
	}
}
