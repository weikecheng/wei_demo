package com.example.technologydemo.singleton;


/**
 * @description:懒汉式单例模式,线程不安全
 * @author weikecheng 
 * @creatTime 2021年2月26日 下午1:20:57  
 * @since 1.0.0
 */
public class Singleton1 {
    private static Singleton1 instance;
    private Singleton1 (){}

	public static synchronized Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
	
//	//优化后
//	private static Class getClass(String classname) throws ClassNotFoundException {
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//
//		if (classLoader == null)
//			classLoader = Singleton1.class.getClassLoader();
//
//		return (classLoader.loadClass(classname));
//	}
}


