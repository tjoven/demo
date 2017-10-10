package com.example.command;

public class DownCommand implements Command{
	Machine machine;
	
	public DownCommand(Machine machine) {
		this.machine=machine;
	}
	@Override
	public void execute() {
		machine.toDown();
	}
}
