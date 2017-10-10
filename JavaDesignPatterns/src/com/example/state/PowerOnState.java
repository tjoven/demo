package com.example.state;

public class PowerOnState implements TvState{


	@Override
	public void turnOn() {
		System.out.println("turnOn");
		
	}

	@Override
	public void turnOff() {
		System.out.println("turnOff");
		
	}

	@Override
	public void changeChannel() {
		System.out.println("changeChannel");
		
	}

}
