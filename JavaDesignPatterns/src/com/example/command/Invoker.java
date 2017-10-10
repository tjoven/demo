package com.example.command;

public class Invoker {
	LeftCommand leftcommand;
	RightCommand rightCommand;
	UpCommand upCommand;
	DownCommand downCommand;
	
	public void setleft(LeftCommand leftcommand) {
		this.leftcommand=leftcommand;
	}
	public void setRight(RightCommand rightCommand) {
		this.rightCommand=rightCommand;
	}
	public void setUp(UpCommand upCommand) {
		this.upCommand=upCommand;
	}
	public void setDown(DownCommand downCommand) {
		this.downCommand=downCommand;
	}
	
	
		public void toLeft(){
			leftcommand.execute();
		}
		public void toRight(){
			rightCommand.execute();
		}
		public void toUp(){
			upCommand.execute();
		}
		public void toDown(){
			downCommand.execute();
		}
}
