package com.example.datasousserdemo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类对应的调用处理程序类
 */
public class SubjectInvocationHandler implements InvocationHandler {
	// 代理类持有一个委托类的对象引用
	private Object delegate;

	public SubjectInvocationHandler(Object delegate) {
		this.delegate = delegate;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy:" + proxy.getClass().getName());
		System.out.println("method:" + method.getName());
		System.out.println("args:" + args[0].getClass().getName());

		System.out.println("Before invoke method...");
		Object object = method.invoke(delegate, args);// 普通的Java反射代码,通过反射执行某个类的某方法
		System.out.println("After invoke method...");
		return object;
	}
	
	public static void main(String[] args) {
		RealSubject demo = new RealSubject();
		InvocationHandler handler = new SubjectInvocationHandler(demo);
		Subject proxy = (Subject) Proxy.newProxyInstance(demo.getClass().getClassLoader(), demo.getClass().getInterfaces(),handler);
		proxy.dealTask("DBQuery");
	}

}
