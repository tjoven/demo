package com.tjoven.mExecutors;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import com.tjoven.mExecutors.NewCachedThreadPoolDemo.MyThread;

/**
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * @author car
 *
 */
public class NewFixedThreadPoolDemo {
	ExecutorService service;
	public static void main(String[] args) {
		NewFixedThreadPoolDemo demo=new NewFixedThreadPoolDemo();
		demo.exe();
	}
	void exe(){
		service=Executors.newFixedThreadPool(5);
		for (int i = 0; i < 20; i++) {
			service.execute(new MyThread(i));
		}
	}
	class MyThread implements Runnable{

		int i;
		public MyThread(int i) {
			this.i=i;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("第"+i+"个线程  "+"@@"+Thread.currentThread().getName());
		}
		
	}
}
