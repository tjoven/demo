package com.example.builder.store;

public class ComputerBuilder implements Builder{

	Macbook macbook = new Macbook();
	@Override
	public void createBoard() {
		// TODO Auto-generated method stub
		macbook.mBoard="board";
	}

	@Override
	public void createDisplay() {
		// TODO Auto-generated method stub
		macbook.mDisplay="diaplsy";
	}

	@Override
	public void createOS() {
		// TODO Auto-generated method stub
		macbook.mOS="os";
	}
	
	public Macbook getComputer(){
		return macbook;
	}
	
}
