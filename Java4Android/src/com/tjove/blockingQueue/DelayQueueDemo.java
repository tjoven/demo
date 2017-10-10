package com.tjove.blockingQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * http://blog.csdn.net/stafen1/article/details/70879818
 * @author car
 *
 */
public class DelayQueueDemo {
	public static void main(String[] args) {
		DelayQueue<TTT> delayQueue = new DelayQueue<TTT>();
		for (int i = 0; i < 5; i++) {
			TTT TTT = new TTT("a", i+1,1000*(5-i));
			delayQueue.add(TTT);
		}
		while(delayQueue.size()>0){
			try {
				TTT TTT = delayQueue.take();
				System.out.println("take:"+TTT.age);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("start"+delayQueue.size());
		for (TTT delayed : delayQueue) {
			System.out.println(delayed.age);
		}
		System.out.println("----------------------------");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end"+delayQueue.size());
		for (TTT delayed : delayQueue) {
			System.out.println(delayed.age);
		}
	}
	
}	
class TTT implements Delayed{
	public String name;
	public int age;
	public long outTime;
	public TTT(String name, int age,long time) {
		super();
		this.name = name;
		this.age = age;
		this.outTime = TimeUnit.NANOSECONDS.convert(time, TimeUnit.MILLISECONDS)+System.nanoTime();
	}
	@Override
	public int compareTo(Delayed another) {
		// TODO Auto-generated method stub
		if(another instanceof TTT){
			TTT ttt = (TTT) another;
			if(this.outTime>ttt.outTime){
				return 1;
			}else if(this.outTime<ttt.outTime){
				return -1;
			}else{
				return 0;
			}
		}
		return 0;
	}
	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		long d = outTime - System.nanoTime();
		return unit.convert(d, TimeUnit.NANOSECONDS);
		
	}
}
