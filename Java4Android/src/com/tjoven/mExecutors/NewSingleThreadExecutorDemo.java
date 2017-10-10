package com.tjoven.mExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * @author car
 *
 */
public class NewSingleThreadExecutorDemo {
	ExecutorService service;
	public static void main(String[] args) {
		NewSingleThreadExecutorDemo demo=new NewSingleThreadExecutorDemo();
		demo.exe();
	}
	void exe(){
		service=Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			 service.execute(new MyThread(i));
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("一共"+Thread.activeCount()+"个线程");
	}
	class MyThread implements Runnable{

		private int i;
		public MyThread(int i) {
			// TODO Auto-generated constructor stub
			this.i=i;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			System.out.println(i+"@@"+Thread.currentThread().getName());
		}
		
	}
}
