package com.tjove.blockingQueue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Test> priorityQueue = new PriorityQueue<Test>();
		Test test1 = new Test(1, "a"); 
		Test test2 = new Test(2, "b"); 
		Test test3 = new Test(3, "c"); 
		Test test4 = new Test(4, "d"); 
		priorityQueue.add(test3);
		priorityQueue.add(test4);
		priorityQueue.add(test4);
		priorityQueue.add(test1);
		priorityQueue.add(test3);
		priorityQueue.add(test3);
		priorityQueue.add(test2);
		

		System.out.println("----------------------");
		for (Test test : priorityQueue) {
			System.out.println(test.age);
		}
		System.out.println("----------------------");
		for(int i = 0;i<4;i++){
			System.out.println(priorityQueue.poll().age);
		}
		
	}
}
class Test implements Comparable<Object>{
	public int age;
	public Test(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public String name;
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Test){
			Test test = (Test) o;
			if(this.age>test.age){
				return 1;
			}else if(this.age<test.age){
				return -1;
			}else {
				return 0;
			}
		}
		return 0;
	}
	
}
