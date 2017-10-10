package com.example.bride;

public class LargeCoffee extends Coffee{

	public LargeCoffee(CoffeeAdditive additive) {
		super(additive);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeCoffee() {
		System.out.println("大杯咖啡");
		additive.addSomething();
		
	}

}
