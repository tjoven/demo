package com.example.strategy;
/**
 * 策略模式（策略模式，就是把选择方法的问题，变成选择类的问题，这样就可以使他们继承同一接口，用到向上转型，有很好的隐蔽性和拓展性）
 * 针对同一类型问题的多种处理方式，仅仅是具体的行为有差别
 * 安全的封装    多种同一类型  的操作（就是实现同一结构的多个实现类）
 * 出现同一抽象类的多个子类，需要用if--else 来选择子类的时候
 * 
 * 策略模式是对算法的封装，它把算法的责任和算法本身分割开，委派给不同的对象管理。
 * 策略模式通常把一个系列的算法封装到一系列的策略类里面，作为一个抽象策略类的子类。
 * 用一句话来说，就是“准备一组算法，并将每一个算法封装起来，使得它们可以互换
 * @author car
 *
 */
public class StrategyPattern {
	Calculator calculator;
	public static void main(String[] args) {
		StrategyPattern pattern=new StrategyPattern();
		pattern.setStrategy(new BusAdvice());
		pattern.getResult();
		
		pattern.setStrategy(new RailwayAdvice());
		pattern.getResult();
		
	}
	void setStrategy(Calculator calculator){
		this.calculator=calculator;
	}
	
	void getResult(){
		calculator.calculatePrice(10);
	}
}
