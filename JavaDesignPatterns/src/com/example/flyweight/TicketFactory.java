package com.example.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 享元模式
 * @author car
 *
 */
public class TicketFactory {
	static Map<String, Ticket> map=new ConcurrentHashMap<String ,Ticket>();
	public static Ticket getTicket(String from,String to){
		String rount=from+"-"+to;
		if (map.containsKey(rount)) {
			System.out.println("从缓存中获取");
			return map.get(from+"-"+to);
		}else {
			System.out.println("new 一个");
			Ticket ticket=new TrainTicket(from,to);
			map.put(rount, ticket);
			return new TrainTicket(from,to);
		}
	}
}
