package com.example.flyweight;
/**
 * 共享模式   和单例模式有类似的地方，即：减少重复对象的创建，但又不太一样
 * @author car
 *
 */
public class Client {
	public static void main(String[] args) {
		Ticket ticket=TicketFactory.getTicket("北京", "天津");
		Ticket ticket2=TicketFactory.getTicket("北京", "天津");
		
		ticket.showTicketInfo("二等座");
		ticket.showTicketInfo("一等座");
		ticket2.showTicketInfo("空等座");
	}
}
