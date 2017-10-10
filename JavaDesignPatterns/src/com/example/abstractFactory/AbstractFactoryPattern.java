package com.example.abstractFactory;
/**
 * 抽象工厂模式:生产的产品是抽象的
 * 缺点：扩展性不好，工厂增加，或者产品增加。就需要相应的修改产品类或抽象的工厂类（具体的工厂类也会相应修改）
 * @author car
 *
 */
public class AbstractFactoryPattern {
	public static void main(String[] args) {
		AbstractFactory factory=new ConcreteFactory1();
		factory.createMouse().iMouse();
		factory.createKeyboard().iKeyboard();
		
		System.out.println("------------------------------------------------");
		
		factory=new ConcreteFactory2();
		factory.createMouse().iMouse();
		factory.createKeyboard().iKeyboard();
	}
}
