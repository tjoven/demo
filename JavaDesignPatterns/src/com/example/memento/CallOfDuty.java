package com.example.memento;

import java.util.ArrayList;

public class CallOfDuty {
	private int checkPoint=1;
	private int lifeValue=100;
	
	public void play() {
		System.out.println(String.format("开始游戏,  现在是第%d关", checkPoint)+String.format("  血条%d", lifeValue));
		System.out.println("升级");
		checkPoint++;
		lifeValue-=10;
		System.out.println(String.format("开始游戏,  现在是第%d关", checkPoint)+String.format("  血条%d", lifeValue));
	}
	public Memento save() {
		Memento memento=new Memento();
		memento.setCheckPoint(checkPoint);
		memento.setLifeValue(lifeValue);
		return memento;
	}
	public void quit(){
		System.out.println("退出游戏");
	}
	public void restore(ArrayList<Memento> mementos) {
		for (Memento memento : mementos) {
			
			checkPoint=memento.getCheckPoint();
			lifeValue=memento.getLifeValue();
			System.out.println(String.format("回复游戏,  现在是第%d关", checkPoint)+String.format("  血条%d", lifeValue));
		}
	}
}
