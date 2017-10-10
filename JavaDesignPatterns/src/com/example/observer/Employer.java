package com.example.observer;

import java.util.Observable;
import java.util.Vector;

public class Employer extends Observable{
	
	public void postMessage(String content){
		System.out.println(hasChanged()+"  Before");
		setChanged();
		System.out.println(hasChanged()+"   After");
		notifyObservers(content);
		System.out.println(hasChanged()+"  Last");
		
	}

}
