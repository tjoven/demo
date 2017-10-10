package com.example.mediator;

public class StudentA extends Student{

	public String msg="StudentA-->StudentB";
	public StudentA(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}
	public void send(){
		mediator.change(this);
	}
	
	public void receive(String msg) {
		System.out.println("StudentA: "+msg);
		
	}

}
