package com.example.proxy;

public class Lawyer implements Laysuit{

	public Laysuit laysuit;
	public Lawyer(Laysuit laysuit) {
		this.laysuit=laysuit;
	}
	@Override
	public void submit() {
		laysuit.submit();
	}

	@Override
	public void burden() {
		laysuit.burden();
	}

}
