package com.example.prototype;

import java.util.ArrayList;

import javax.naming.Context;

public class WordDocument implements Cloneable{
	
	String text;
	ArrayList<String> images=new ArrayList<String>();
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<String> getImages() {
		return images;
	}
	public void addImages(String text) {
		images.add(text);
	}
	public void print(String context) {
		
		System.out.println("----------------"+context+"---------start--------------------------");
		System.out.println(this.text);
		for (String item : images) {
			System.out.println(item);
		}
	}
	@Override
	protected Object clone()  {
		// TODO Auto-generated method stub
		try {
			WordDocument documentCopy=(WordDocument) super.clone();
			documentCopy.text=this.text;
			documentCopy.images=this.images;//浅拷贝
//			documentCopy.images=(ArrayList<String>) this.images.clone()//深拷贝
			return documentCopy;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
