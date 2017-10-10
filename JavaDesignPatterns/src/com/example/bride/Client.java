package com.example.bride;
/**
 * 桥接模式
 * @author car
 *
 */
public class Client {
	public static void main(String[] args) {
		SugarCoffee sugar=new SugarCoffee();
		OrdinaryCoffee ordinary=new OrdinaryCoffee();
		
		LargeCoffee coffee=new LargeCoffee(sugar);
		coffee.makeCoffee();
		
		LargeCoffee coffee2=new LargeCoffee(ordinary);
		coffee2.makeCoffee();
		
		SmallCoffee coffee3=new SmallCoffee(sugar);
		coffee3.makeCoffee();
		
		SmallCoffee coffee4=new SmallCoffee(ordinary);
		coffee4.makeCoffee();
	}
}
