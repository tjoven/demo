package com.example.state;
/**
 * 状态模式
 * @author car
 *我们将这些状态（if...else）用对象来代替，将这些行为封装到对象中。
 *开机/关机两个状态，变成两个状态，三个方法封装到状态的共同接口上
 */
public class StatePattern {
	public static void main(String[] args) {
		TvController controller = new TvController();
		controller.powerOn();
		controller.turnOn();
		controller.turnOff();
		controller.changeChannel();
		
		System.out.println("------------------------------------------------");
		
		controller.powerOff();
		controller.turnOn();
		controller.turnOff();
		controller.changeChannel();
	}
}
