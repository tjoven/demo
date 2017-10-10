package com.example.designpatterns;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;

public class DiskCache implements ImageCache{

	String cacheDir="sdcard/cache";
	@Override
	public Bitmap get(String url) {
		// TODO Auto-generated method stub
		return BitmapFactory.decodeFile(cacheDir+url);
	}

	@Override
	public void put(String url, Bitmap bitmap) {
		FileOutputStream fileOutputStream=null;
		try {
			fileOutputStream=new FileOutputStream(cacheDir+url);
			bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			CloseUtils.close(fileOutputStream);
		}
		
		
	}
	
}
