package com.example.datasousserdemo.dynamicproxy;

/**
 * 代理类，实现类代理接口
 * @author zhangliang
 * 2016年4月5日 下午6:58:06
 */
public class ProxySubject implements Subject {
	//代理类持有一个委托类的对象引用  
	 private Subject delegate;  	   
	 public ProxySubject(Subject delegate) {  
	  this.delegate = delegate;  
	 }  	
	@Override
	public void dealTask(String taskName) {
		// TODO Auto-generated method stub
		 System.out.println("do something before");
		 delegate.dealTask(taskName);
	     System.out.println("do something after");
	}
	
	public static void main(String[] args) {
		Subject proxySubject = new ProxySubject(new RealSubject());
		proxySubject.dealTask("DBQueryTask");
	}
}
