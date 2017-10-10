package com.example.command;

public class LeftCommand implements Command{
	Machine machine;
	
	public LeftCommand(Machine machine) {
		this.machine=machine;
	}
	@Override
	public void execute() {
		machine.toLeft();
	}
}
