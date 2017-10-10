package com.example.flyweight;

import java.util.Random;

public class TrainTicket implements Ticket{

	private String from;
	private String to;
	public TrainTicket(String from,String to) {
		this.from=from;
		this.to=to;
	}
	@Override
	public void showTicketInfo(String bunk) {
		int price=new Random().nextInt(100);
		System.out.println("从"+from+"到"+to+"的"+bunk+"火车票价格是："+price);
	}

}
