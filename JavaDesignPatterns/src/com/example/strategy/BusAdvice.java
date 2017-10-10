package com.example.strategy;

public class BusAdvice implements Calculator{

	@Override
	public void calculatePrice(int price) {
		System.out.println("做公交车的价格");
		
	}

}
