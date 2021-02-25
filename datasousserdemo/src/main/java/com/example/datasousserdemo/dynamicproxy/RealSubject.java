package com.example.datasousserdemo.dynamicproxy;

/**
 * 真实类，处理具体业务
 * @author zhangliang
 *
 * 2016年4月5日 下午6:53:16
 */
public class RealSubject implements Subject {	
	@Override
	public void dealTask(String taskName) {
		// TODO Auto-generated method stub
		System.out.println("realSubject正在执行任务："+taskName);  
	}
}
