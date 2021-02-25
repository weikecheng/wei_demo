package com.example.datasousserdemo.controller;

import com.example.datasousserdemo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0.0
 * @ProjectName: springcloud-book-master
 * @ClassName: TestController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: weikecheng
 * @Date: 2021/2/3 16:37
 */
@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private ITestService testService;

	@RequestMapping("/add")
//    @Transactional
	public String add() {
		testService.add1();
		testService.add2();
		return "";
	}

	@RequestMapping("/test")
//  @Transactional
	public String test() {
		testService.test();
		return "";
	}
}
