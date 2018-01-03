package com.example.builder.store;

public class Macbook {

	protected String mBoard;
	protected String mDisplay;
	protected String mOS;
	
	@Override
	public String toString(){
		return mBoard+mDisplay+mOS;
		
	}
}
