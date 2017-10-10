package com.example.builder;

public class Macbook extends Computer{

	MacbookBuilder builder;
	public Macbook(MacbookBuilder builder) {
		this.mDisplay=builder.mDisplay;
		this.mBoard=builder.mBoard;
		this.mOS=builder.mOS;
	}
	
	public static class MacbookBuilder extends Builder{

		protected String mBoard;
		protected String mDisplay;
		protected String mOS;
		
		//设置主板
		public MacbookBuilder setBoard(String mBoard) {
			this.mBoard=mBoard;
			return this;
		}
		//设置显示器
		public MacbookBuilder setDisplay(String mDisplay) {
			this.mDisplay=mDisplay;
			return this;
		}
		
		@Override
		public MacbookBuilder setOS(String mOS) {
			this.mOS=mOS;
			return this;
		}
		
		@Override
		public Computer build(){
			return new Macbook(this);
		}
			
	}

}
