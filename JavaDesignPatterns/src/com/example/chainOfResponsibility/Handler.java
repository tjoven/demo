package com.example.chainOfResponsibility;
/**
 * 抽象处理者
 * @author car
 *
 */
public abstract class Handler {
	Handler nextHandler=null;
	
	public void handleRequest(Problem problem) {
		if (limit(problem)) {
			handle();
		}else {
			nextHandler.handleRequest(problem);
		}
	}
	public abstract boolean limit(Problem problem);
	private void handle(){
		System.out.println(this.getClass().getSimpleName().toString()+" 报销");
	}
}