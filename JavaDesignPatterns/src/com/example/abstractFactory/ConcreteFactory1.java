package com.example.abstractFactory;

public class ConcreteFactory1 extends AbstractFactory{

	@Override
	public Mouse createMouse() {
		// TODO Auto-generated method stub
		return new NormalMouse();
	}

	@Override
	public Keyboard createKeyboard() {
		// TODO Auto-generated method stub
		return new NormalKeyboard();
	}

}
