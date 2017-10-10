package com.example.bride;

public abstract class Coffee {
	CoffeeAdditive additive;
	public Coffee(CoffeeAdditive additive) {
		this.additive=additive;
		System.out.println("---------------------------------------");
	}
	public abstract void makeCoffee();
}
