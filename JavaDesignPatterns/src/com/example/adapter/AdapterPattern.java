package com.example.adapter;
/**
 * 适配器模式：把一个类的接口换成客户端期待的另一种接口，使原本接口不匹配的两个类能在一起工作
 * 类适配器模式
 * 对象适配器模式
 * 
 * 220V电压经过适配器变成5V可用电压
 * @author car
 *
 */
public class AdapterPattern {
	public static void main(String[] args) {
		Volt220 volt220=new Volt220();
		VoltAdapter adapter=new VoltAdapter(volt220);//对象适配器模式，多用聚合和合成，少用继承
		adapter.outputFiveVolt();
	}
	
}
