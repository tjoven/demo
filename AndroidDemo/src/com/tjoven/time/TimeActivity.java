package com.tjoven.time;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class TimeActivity extends BaseActivity{
	int i=0;
	Button button;
	TextView textView;
	Timer timer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		timer=new Timer();
		textView=(TextView) findViewById(R.id.text);
		button=(Button) findViewById(R.id.button01);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				timer.cancel();
			}
		});
	
		TimerTask task=new TimerTask() {
			
			@Override
			public void run() {//类似 Runnable的线程体
				i++;
				runOnUiThread(new Runnable() {
					public void run() {
						textView.setText(i+"");//必须在主线程修改UI
					}
				});
			}
		};
		timer.schedule(task, 2000, 1000);//开启新线程
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		timer.cancel();
	}
}
