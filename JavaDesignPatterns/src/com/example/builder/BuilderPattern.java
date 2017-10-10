package com.example.builder;

/**
 * 创建者模式
 * @author car
 *
 */
public class BuilderPattern {
	
	public static void main(String[] args) {
		BuilderPattern pattern=new BuilderPattern();
		pattern.build();
	}
	public void build() {
		Macbook.MacbookBuilder builder=new Macbook.MacbookBuilder();
		Computer macbook=builder.setBoard("英特尔 I7").setDisplay("Retina 显示器").setOS("MacOS").build();
		
		System.out.println(macbook.toString());
		
		
	}
}
