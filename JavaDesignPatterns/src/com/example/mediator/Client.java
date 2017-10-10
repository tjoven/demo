package com.example.mediator;

public class Client {
	public static void main(String[] args) {
		ConcreteMediator mediator=new ConcreteMediator();
		StudentA studentA=new StudentA(mediator);
		StudentB studentB=new StudentB(mediator);
		mediator.setStudentA(studentA);
		mediator.setStudentB(studentB);
		
		studentA.send();
		studentB.send();
	}
}
