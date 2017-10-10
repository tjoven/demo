package com.example.proxy;

public class Customer implements Laysuit{

	@Override
	public void submit() {
		System.out.println("申请");
	}

	@Override
	public void burden() {
		System.out.println("举证");
	}

}
