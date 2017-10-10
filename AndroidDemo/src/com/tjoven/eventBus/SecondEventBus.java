package com.tjoven.eventBus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

import de.greenrobot.event.EventBus;


public class SecondEventBus extends BaseActivity{
	
	@ViewInject(R.id.button01)
	private Button button;
	@ViewInject(R.id.text)
	private TextView textView;
	
	Context context=SecondEventBus.this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ViewUtils.inject(this);
		EventBus.getDefault().register(this);
		textView.setText("SecondEventBus准备接受来自总线的消息");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(context, OtherActivity.class);
				startActivity(intent);
				
			}
		});
	}
	public void onEventMainThread(Data event){
		System.out.println("SecondEventBus"+event.name+": "+event.age);
		textView.setText("SecondEventBus接受的总线消息是: "+event.age);
		showToast(context, "SecondEventBus:年龄： "+event.name);
	}

}
