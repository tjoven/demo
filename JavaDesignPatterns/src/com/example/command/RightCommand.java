package com.example.command;

public class RightCommand implements Command{
	Machine machine;
	
	public RightCommand(Machine machine) {
		this.machine=machine;
	}
	@Override
	public void execute() {
		machine.toRight();
	}
}
