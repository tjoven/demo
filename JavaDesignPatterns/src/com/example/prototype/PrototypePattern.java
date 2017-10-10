package com.example.prototype;

import java.util.ArrayList;

import javax.naming.Context;

public class PrototypePattern {
	public static void main(String[] args) {
		WordDocument document=new WordDocument();
		document.setText("text One");
		document.addImages("Image One");
		document.addImages("Image Two");
		document.addImages("Image Three");
		document.print("document");
		
		WordDocument document2=(WordDocument) document.clone();
		document2.print("document2");
		
		document2.setText("text Copy");
		document2.addImages("Image Copy");
		document2.print("document2");
		
		document.print("document");
		
	}
}
