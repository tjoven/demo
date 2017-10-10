package com.tjoven.volley;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class ImageRequestDemo extends BaseActivity{
	
	@ViewInject(R.id.button)
	private Button button;
	
	@ViewInject(R.id.button2)
	private Button imageLoaderBt;
	
	@ViewInject(R.id.button3)
	private Button networkBt;
	
	@ViewInject(R.id.imageView)
	private ImageView imageView;
	
	@ViewInject(R.id.network_iv)
	private NetworkImageView network_iv;
	
	String TAG=ImageRequestDemo.class.getSimpleName();
	RequestQueue queue;
	BitmapCache bitmapCache;
	ImageLoader imageLoader;
	String url= "http://sc.admin5.com/uploads/allimg/100222/14153T363-0.jpg";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_view);
		ViewUtils.inject(this);

		init();
		button.setText("imageRequest加载图片");
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				request();
			}

		});
		
		imageLoaderBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				request2();
				
			}
		});
		
		network_iv.setDefaultImageResId(R.drawable.ic_launcher);;
		network_iv.setErrorImageResId(R.drawable.work_state_press);;
		
		networkBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				imageLoader=new ImageLoader(queue,bitmapCache);
				network_iv.setImageUrl(url, imageLoader);
				
			}
		});
	}
	private void init() {
		
		queue=Volley.newRequestQueue(this);
		bitmapCache= new BitmapCache();
	
	}
	protected void request2() {
		//创建ImageLoader
		imageLoader=new ImageLoader(queue,bitmapCache);
		//创建ImageListener
		ImageListener imageListener=imageLoader.getImageListener(imageView, R.drawable.ic_launcher, R.drawable.work_state_press);
		//调用ImageLoader的get()方法加载网络上的图片。
		imageLoader.get(url, imageListener);
	}
	private void request() {
		
		//有点慢啊！
		ImageRequest request=new ImageRequest(url, new Listener<Bitmap>() {

			@Override
			public void onResponse(Bitmap response) {
				imageView.setImageBitmap(response);
				
			}
		}, 0, 0, Config.RGB_565, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				imageView.setImageResource(R.drawable.ic_launcher);
				Log.e(TAG, error.getMessage());
			}
		});
		
		queue.add(request);
	}
	class BitmapCache implements ImageCache{

	 private LruCache<String, Bitmap> mCache;  
	 
	 public BitmapCache() {  
	        int maxSize = 10 * 1024 * 1024;  
	        mCache = new LruCache<String, Bitmap>(maxSize) {  
	            @Override  
	            protected int sizeOf(String key, Bitmap bitmap) {  
	                return bitmap.getRowBytes() * bitmap.getHeight();  
	            }  
	        };  
	    }
		@Override
		public Bitmap getBitmap(String url) {
			// TODO Auto-generated method stub
			Log.i(TAG, "getBitmap    "+url);
			 return mCache.get(url);  
		}

		@Override
		public void putBitmap(String url, Bitmap bitmap) {
			  mCache.put(url, bitmap);  
			  Log.i(TAG, "putBitmap    "+url);
		}
		
	}
}
