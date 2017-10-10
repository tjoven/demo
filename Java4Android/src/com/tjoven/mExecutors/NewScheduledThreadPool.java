package com.tjoven.mExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 线程池
 * @author car
 *
 */
public class NewScheduledThreadPool  {

	public static void main(String[] args) {
		NewScheduledThreadPool demo=new NewScheduledThreadPool();
		demo.exe();

	}
	void exe(){
			ScheduledExecutorService executorService=Executors.newScheduledThreadPool(2);
			executorService.scheduleAtFixedRate(new MyThread(), 2000, 1000, TimeUnit.MILLISECONDS);
			executorService.scheduleAtFixedRate(new MyThread(), 2000, 1000, TimeUnit.MILLISECONDS);
//			for (int i = 0; i < 10; i++) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				executorService.schedule(new MyThread(i), 1, TimeUnit.SECONDS);
//			}
	}

}
class MyThread implements Runnable{
	int i=0;
	public MyThread(int i) {
		this.i=i;
	}
	public MyThread() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		System.out.println(i+"@@@"+Thread.currentThread().getName());
	}
}
