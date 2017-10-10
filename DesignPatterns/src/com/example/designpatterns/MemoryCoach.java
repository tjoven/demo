package com.example.designpatterns;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class MemoryCoach implements ImageCache{

	LruCache<String, Bitmap> cache;
	public MemoryCoach() {
		int maxMemory=(int) (Runtime.getRuntime().maxMemory()/1024);
		int cacheSize=maxMemory/4;
		cache=new LruCache<String, Bitmap>(cacheSize){
			@Override
			protected int sizeOf(String key, Bitmap bitmap) {
				// TODO Auto-generated method stub
				return bitmap.getRowBytes()*bitmap.getHeight()/1024;
			}
		};
	}
	@Override
	public Bitmap get(String url) {
		
		return cache.get(url);
	}

	@Override
	public void put(String url, Bitmap bitmap) {
		cache.put(url, bitmap);
		
	}

}
