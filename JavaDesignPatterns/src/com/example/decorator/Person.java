package com.example.decorator;
/**
 * 被装饰的具体对象
 * @author car
 *
 */
public class Person implements Human{

	@Override
	public void eatFood() {
		System.out.println("吃米饭");
		
	}

	@Override
	public void wearClothes() {
		System.out.println("穿衣服");
		
	}

}
