package com.example.observer;

public class ObserverPattern {
	public static void main(String[] args) {
		
		Employer employer=new Employer();
		
		employer.addObserver(new Employee("1号"));
		employer.addObserver(new Employee("2号"));
		employer.addObserver(new Employee("3号"));
		employer.addObserver(new Employee("4号"));
		employer.addObserver(new Employee("5号"));
		employer.addObserver(new Employee("6号"));
		
		employer.postMessage("加班通知");//反向输出结果，即：后添加观察的先执行
	}
}
