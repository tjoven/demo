package com.example.chainOfResponsibility;
/**
 * 责任链模式
 * 使多个对象都有机会处理请求，将这些对象连成一条链，知道有对象处理为止
 * @author car
 *
 */
public class Client {
	public static void main(String[] args) {
		LeaderHandler leaderHandler=new LeaderHandler();
		ManagerHandler managerHandler=new ManagerHandler();
		BossHandler bossHandler= new BossHandler();
		
		leaderHandler.nextHandler=managerHandler;
		managerHandler.nextHandler=bossHandler;
		
		Problem problem=new Problem();
		problem.money=8000;
		leaderHandler.handleRequest(problem);
	}
}
