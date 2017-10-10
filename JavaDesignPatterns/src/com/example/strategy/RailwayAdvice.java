package com.example.strategy;

public class RailwayAdvice implements Calculator{

	@Override
	public void calculatePrice(int price) {
		System.out.println("坐地铁的价格");
		
	}

}
