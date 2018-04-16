package com.example.builder.store;


public class BuilderPattern {
	public static void main(String[] args) {
		BuilderPattern pattern=new BuilderPattern();
		pattern.build();
	}
	public void build() {
		ComputerBuilder builder = new ComputerBuilder();
		Director director = new Director();
		director.command(builder);
		System.out.println(builder.getComputer().toString());
	}
}
