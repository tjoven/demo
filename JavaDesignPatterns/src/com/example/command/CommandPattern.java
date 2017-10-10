package com.example.command;
/**
 * 命令模式： 将行为调用者和实现者解耦
 * @author car
 *不太懂，为什么要这么啰嗦？？？
 */
public class CommandPattern {
	public static void main(String[] args) {
		
		Machine machine=new Machine();
		Invoker invoker=new Invoker();
		
		LeftCommand leftcommand=new LeftCommand(machine);
		RightCommand rightCommand=new RightCommand(machine);
		UpCommand upCommand=new UpCommand(machine);
		DownCommand downCommand=new DownCommand(machine);
		
		invoker.setleft(leftcommand);
		invoker.setRight(rightCommand);
		invoker.setUp(upCommand);
		invoker.setDown(downCommand);
		
		invoker.toLeft();
		invoker.toRight();
		invoker.toUp();
		invoker.toDown();
	}
	
}
