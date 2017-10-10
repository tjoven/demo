package com.tjoven.memoryLeak;

import java.lang.ref.WeakReference;



import com.tjove.ipcdemo.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * 内存泄漏
 * @author car
 *
 */
public class MemoryLeak extends Activity{
	
	MyHandler handler=new MyHandler(this);
	
	private static class MyHandler extends Handler{
		
		WeakReference<Activity> weakReference=null;
		public MyHandler(Activity activity) {
			weakReference=new WeakReference<Activity>(activity);
		}
		public void handleMessage(android.os.Message msg) {
			MemoryLeak activity=(MemoryLeak) weakReference.get();
			if (weakReference.get()!=null) {
				Log.e("tag", "@@@@@@@@@@@@@@@@@@@@@@@@"+activity.getTaskId());
			}else {
				Log.e("tag", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		handler.sendMessageDelayed(Message.obtain(), 2000);
		
		Log.e("tag", getClass().getName());
//		finish();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		handler.removeCallbacksAndMessages(null);//finish之后 消息仍然存在消息队列中，最好把他们移除
	}

}
