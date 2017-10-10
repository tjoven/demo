package com.example.observer;

import java.util.Observable;
import java.util.Observer;

public class Employee implements Observer{

	String name;
	public Employee(String name) {
		this.name=name;
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(name+"收到"+arg.toString());
	}
	
	

}
