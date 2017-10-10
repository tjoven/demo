package com.example.designpatterns;

import android.graphics.Bitmap;

interface ImageCache {

	 public Bitmap get(String url);
	 public void put(String url,Bitmap bitmap);
	 
}
