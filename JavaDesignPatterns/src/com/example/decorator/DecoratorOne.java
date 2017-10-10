package com.example.decorator;

public class DecoratorOne extends Decorator{

	public DecoratorOne(Human human) {
		super(human);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void eatFood() {
		// TODO Auto-generated method stub
		super.eatFood();
		say();
	}

	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		super.wearClothes();
		walk();
	}
	public void walk() {
		System.out.println("walk");
	}
	public void say() {
		System.out.println("say");
	}
}
