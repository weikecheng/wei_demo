package com.example.datasousserdemo;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description:线程池使用样例
 * @author weikecheng 
 * @creatTime 2021年2月25日 上午10:59:10  
 * @since 1.0.0
 */
public class ThreadPoolDemo {
	
	/**
	 * @description:固定大小的线程池使用实例(优点：newFixedThreadPool的线程数是可以进行控制的，因此我们可以通过控制最大线程来使我们的服务器打到最大的使用率，同事又可以保证及时流量突然增大也不会占用服务器过多的资源。)
	 * @author weikecheng  
	 * @throws InterruptedException 
	 * @since 1.0.0 
	 * @throws
	 */
	public static void method_01() {

		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			final int index = i;

			executor.execute(() -> {
				try {
					Thread.sleep(2 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "  " + index);
			});
		}
		executor.shutdown();
	}
	
	/**
	 * @description:该线程池支持定时，以及周期性的任务执行，我们可以延迟任务的执行时间，
	   * 也可以设置一个周期性的时间让任务重复执行.
	 * (如果间隔时间大于任务的执行时间，任务不受执行时间的影响。如果间隔时间小于任务的执行时间，
	   * 那么任务执行结束之后，会立马执行，至此间隔时间就会被打乱。)
	 * @author weikecheng   
	 * @since 1.0.0 
	 * @throws
	 */
	public static void method_02() { 
	    ScheduledExecutorService executor = Executors.newScheduledThreadPool(5); 
	 
	    executor.scheduleAtFixedRate(new Runnable() { 
	        @Override 
	        public void run() { 
	            long start = new Date().getTime(); 
	            System.out.println("scheduleAtFixedRate 开始执行时间:" + 
	                    DateFormat.getTimeInstance().format(new Date())); 
	            try { 
	                Thread.sleep(6000); 
	            } catch (InterruptedException e) { 
	                e.printStackTrace(); 
	            } 
	            long end = new Date().getTime(); 
	            System.out.println("scheduleAtFixedRate 执行花费时间=" + (end - start) / 1000 + "m"); 
	            System.out.println("scheduleAtFixedRate 执行完成时间：" + DateFormat.getTimeInstance().format(new Date())); 
	            System.out.println("======================================"); 
	        } 
	    }, 1, 5, TimeUnit.SECONDS); 
	} 
	
	/**
	 * @description:该线程池支持定时，以及周期性的任务执行，我们可以延迟任务的执行时间，
	   * 也可以设置一个周期性的时间让任务重复执行.
	 * (scheduleWithFixedDelay的间隔时间不会受任务执行时间长短的影响。)
	 * @author weikecheng   
	 * @since 1.0.0 
	 * @throws
	 */
	public static void method_03() { 
	    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2); 
	 
	    executor.scheduleWithFixedDelay(new Runnable() { 
	        @Override 
	        public void run() { 
	            long start = new Date().getTime(); 
	            System.out.println("scheduleWithFixedDelay 开始执行时间:" + 
	                    DateFormat.getTimeInstance().format(new Date())); 
	            try { 
	                Thread.sleep(1000); 
	            } catch (InterruptedException e) { 
	                e.printStackTrace(); 
	            } 
	            long end = new Date().getTime(); 
	            System.out.println("scheduleWithFixedDelay执行花费时间=" + (end - start) / 1000 + "m"); 
	            System.out.println("scheduleWithFixedDelay执行完成时间：" 
	                    + DateFormat.getTimeInstance().format(new Date())); 
	            System.out.println("======================================"); 
	        } 
	    }, 1, 2, TimeUnit.SECONDS); 
	} 
	
	/**
	 * @description:单线程的线程池,至始至终都由一个线程来执行。 
	 * @author weikecheng   
	 * @since 1.0.0 
	 * @throws
	 */
	public static void method_04() {

		ExecutorService executor = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 5; i++) {
			final int index = i;
			executor.execute(() -> {
				try {
					Thread.sleep(2 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "   " + index);
			});
		}
		executor.shutdown();
	}

	public static void main(String[] args) {
		method_04();
	}
}
