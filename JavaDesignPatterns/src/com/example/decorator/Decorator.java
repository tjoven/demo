package com.example.decorator;

public abstract class Decorator implements Human{
	
	private Human human;
	
	public Decorator(Human human) {
		this.human=human;
	}
	@Override
	public void eatFood() {
		human.eatFood();
		
	}

	@Override
	public void wearClothes() {
		human.wearClothes();
		
	}

}
