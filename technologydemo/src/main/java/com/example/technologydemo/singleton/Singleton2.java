package com.example.technologydemo.singleton;


/**
 * @description:饿汉式式单例模式,线程安全(不适合集群)
 * @author weikecheng 
 * @creatTime 2021年2月26日 下午1:20:57  
 * @since 1.0.0
 */
public class Singleton2 {  
	private static Singleton2 instance = new Singleton2();

	private Singleton2() {
	}

	public static Singleton2 getInstance() {
		return instance;
	}
}

//优化后
//public class Singleton2 implements java.io.Serializable {
//	public static Singleton2 INSTANCE = new Singleton2();
//
//	protected Singleton2() {
//
//	}
//
//	private Object readResolve() {
//		return INSTANCE;
//	}
//}

