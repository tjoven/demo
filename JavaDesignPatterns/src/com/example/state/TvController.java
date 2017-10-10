package com.example.state;

public class TvController implements PowerController,TvState{
	TvState state;
	private  void setState(TvState state) {
		this.state=state;
	}
/*
 状态
 */
	@Override
	public void powerOn() {
		setState(new PowerOnState());
		System.out.println("PowerOnState");
	}

	@Override
	public void powerOff() {
		setState(new PowerOffState());
		System.out.println("PowerOffState");
	}

	
	
	/*
	 方法
	 */
	
	@Override
	public void turnOn() {
		state.turnOn();
	}

	@Override
	public void turnOff() {
		state.turnOff();
	}

	@Override
	public void changeChannel() {
		state.changeChannel();
	}
}
