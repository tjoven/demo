package com.example.facade;
/**
 * 外观模式
 * 统一接口封装，为用户提供一个高层次的接口
 * @author car
 *
 */
public class Client {
	public static void main(String[] args) {
		MobilePhone mobilePhone=new MobilePhone();
		mobilePhone.call();
		System.out.println("------------------------------");
		mobilePhone.takePicture();
		System.out.println("------------------------------");
		mobilePhone.videoChat();
	}
}
