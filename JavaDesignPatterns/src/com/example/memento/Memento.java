package com.example.memento;
/**
 * 备忘录，用于存储 CallOfDuty内部状态
 * @author car
 *
 */
public class Memento {
	private int checkPoint;
	private int lifeValue;
	public int getCheckPoint() {
		return checkPoint;
	}
	public void setCheckPoint(int checkPoint) {
		this.checkPoint = checkPoint;
	}
	public int getLifeValue() {
		return lifeValue;
	}
	public void setLifeValue(int lifeValue) {
		this.lifeValue = lifeValue;
	}
}
