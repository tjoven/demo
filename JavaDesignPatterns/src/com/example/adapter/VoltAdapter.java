package com.example.adapter;

public class VoltAdapter implements FiveVolt{

	Volt220 volt220;
	public VoltAdapter(Volt220 volt220) {
		this.volt220=volt220;
	}
	@Override
	public void outputFiveVolt() {
		System.out.println("outputFiveVolt");
		
	}

}
