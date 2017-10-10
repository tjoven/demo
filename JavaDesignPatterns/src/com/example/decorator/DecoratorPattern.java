package com.example.decorator;
/**
 * 装饰者模式
 * 动态给一个对象添加一些额外的职责,
 * 就象在墙上刷油漆.使用Decorator模式相比用生成子类方式达到功能的扩充显得更为灵活。
 * 
 * 要点：  装饰者与被装饰者拥有共同的超类，继承的目的是继承类型，而不是行为
 * @author car
 *
 */
public class DecoratorPattern {

	public static void main(String[] args) {
		Human human=new Person();
		Decorator decorator=new DecoratorOne(new DecoratorTwo(human));
		decorator.eatFood();
		System.out.println("============================================");
		decorator.wearClothes();

	}

}
