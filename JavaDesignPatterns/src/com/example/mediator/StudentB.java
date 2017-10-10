package com.example.mediator;

public class StudentB extends Student{

	public String msg="StudentB-->StudentA";
	public StudentB(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}
	public void send(){
		mediator.change(this);
	}
	
	public void receive(String msg) {
		System.out.println("StudentB: "+msg);
		
	}

}
