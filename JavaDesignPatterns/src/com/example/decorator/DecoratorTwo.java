package com.example.decorator;

import com.example.decorator.Decorator;
import com.example.decorator.Human;

public class DecoratorTwo extends Decorator{

	public DecoratorTwo(Human human) {
		super(human);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void eatFood() {
		// TODO Auto-generated method stub
		super.eatFood();
		sing();
	}

	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		super.wearClothes();
		run();
	}
	
	private void sing() {
		System.out.println("sing");
	}
	
	private void run() {
		System.out.println("run");
	}
}
