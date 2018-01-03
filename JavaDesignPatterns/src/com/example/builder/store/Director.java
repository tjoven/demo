package com.example.builder.store;

public class Director {

	public void command(Builder builder){
		builder.createOS();
		builder.createDisplay();
		builder.createBoard();
	}
}
