package com.example.builder;
/**
 * 被创建者 的抽象
 * @author car
 *
 */
public abstract class Computer {
	protected String mBoard;
	protected String mDisplay;
	protected String mOS;
	
	@Override
	public String toString() {
		return mBoard+" "+mDisplay+" "+mOS;
	}
}
