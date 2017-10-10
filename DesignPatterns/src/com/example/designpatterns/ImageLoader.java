package com.example.designpatterns;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

public class ImageLoader {
	
	static ImageCache imageCache=new MemoryCoach();
	static ExecutorService executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	public void setImageCache(ImageCache imageCache) {
		this.imageCache = imageCache;
	}
	public static void displayImage(String url,ImageView imageView){
		Bitmap bitmap=imageCache.get(url);
		if (bitmap!=null) {//有缓存
			imageView.setImageBitmap(bitmap);
			return;
		}
		//没有缓存，在线下载
		request(url,imageView);
	}

	private static void request(final String url,final ImageView imageView) {
		imageView.setTag(url);
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				Bitmap bitmap=downloadImage(url);
				if (bitmap!=null) {
					if (imageView.getTag().equals(url)) 
					{
						imageView.setImageBitmap(bitmap);
						imageCache.put(url, bitmap);
					}
				}
			}
		});
		
	}

	private static Bitmap downloadImage(String imageUrl) {
		URL url;
		Bitmap bitmap=null;
		try {
			url = new URL(imageUrl);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			InputStream inputStream=connection.getInputStream();
			bitmap=BitmapFactory.decodeStream(inputStream);
			connection.disconnect();
		} catch (Exception e) {
			Log.e("tag", e.toString());
		}
		return bitmap;
		
	}

}
