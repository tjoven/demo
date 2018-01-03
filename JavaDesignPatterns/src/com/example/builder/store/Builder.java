package com.example.builder.store;

import com.example.builder.Computer;

interface Builder {
	//设置主板
	public abstract void createBoard();
	//设置显示器
	public abstract void createDisplay();
	//设置操作系统
	public abstract void createOS();

}
