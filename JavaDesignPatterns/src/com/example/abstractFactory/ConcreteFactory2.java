package com.example.abstractFactory;

public class ConcreteFactory2 extends AbstractFactory{

	@Override
	public Mouse createMouse() {
		// TODO Auto-generated method stub
		return new SpecialMouse();
	}

	@Override
	public Keyboard createKeyboard() {
		// TODO Auto-generated method stub
		return new SpecailKeyboard();
	}

}
