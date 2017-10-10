package com.example.memento;

public class Client {
	public static void main(String[] args) {
		CallOfDuty callOfDuty=new CallOfDuty();
		Caretaker caretaker=new Caretaker();
		
		for (int i = 0; i < 4; i++) {
			callOfDuty.play();
			caretaker.addMemento(callOfDuty.save());//存档
			callOfDuty.quit();
			System.out.println("------------------------------------------");
			
		}
		callOfDuty.restore(caretaker.getMementos());//读档
		
		
	}
}
