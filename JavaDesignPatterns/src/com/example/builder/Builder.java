package com.example.builder;

/**
 * 抽象的 创建者
 * @author car
 *
 */
public abstract class Builder {
	protected String mBoard;
	protected String mDisplay;
	protected String mOS;
	
	//设置主板
	public abstract Builder setBoard(String mBoard);
	//设置显示器
	public abstract Builder setDisplay(String mDisplay);
	//设置操作系统
	public abstract Builder setOS(String mOS);
	//生成一个电脑
	public abstract Computer build();
}
