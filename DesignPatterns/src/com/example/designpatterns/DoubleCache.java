package com.example.designpatterns;

import android.graphics.Bitmap;

public class DoubleCache implements ImageCache{

	ImageCache memoryCache=new MemoryCoach();
	ImageCache diskCache=new MemoryCoach();
	
	@Override
	public Bitmap get(String url) {
		Bitmap bitmap=memoryCache.get(url);
		if (bitmap==null) {
			bitmap=diskCache.get(url);
		}
		return null;
	}

	@Override
	public void put(String url, Bitmap bitmap) {
		memoryCache.put(url, bitmap);
		diskCache.put(url, bitmap);
		
	}

}
