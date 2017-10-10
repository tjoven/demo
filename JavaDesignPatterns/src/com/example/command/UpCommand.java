package com.example.command;

public class UpCommand implements Command{
	Machine machine;
	
	public UpCommand(Machine machine) {
		this.machine=machine;
	}
	@Override
	public void execute() {
		machine.toUp();
	}
}
