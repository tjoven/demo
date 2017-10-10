package com.tjoven.mExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 *  newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
 * @author car
 *
 */
public class NewCachedThreadPoolDemo {
	ExecutorService service;
	
	public static void main(String[] args) {
		NewCachedThreadPoolDemo demo=new NewCachedThreadPoolDemo();
		demo.exe();
	}
	void exe(){
		service=Executors.newCachedThreadPool(); 
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(100);//每隔100ms开启一个新线程
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			service.execute(new MyThread(i));
			System.out.println("一共"+Thread.activeCount()+"个线程");
		}
		
	}
	class MyThread implements Runnable{

		int i;
		public MyThread(int i) {
			this.i=i;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("第"+i+"个线程  "+"@@"+Thread.currentThread().getName());
		}
	}
}
