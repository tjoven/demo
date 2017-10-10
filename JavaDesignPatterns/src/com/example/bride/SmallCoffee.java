package com.example.bride;

public class SmallCoffee extends Coffee{

	public SmallCoffee(CoffeeAdditive additive) {
		super(additive);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeCoffee() {
		
		System.out.println("小杯咖啡");
		additive.addSomething();
		
	}

}
