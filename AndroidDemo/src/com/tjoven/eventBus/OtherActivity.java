package com.tjoven.eventBus;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

import de.greenrobot.event.EventBus;

public class OtherActivity extends BaseActivity{
	@ViewInject(R.id.button)
	private Button button;
	@ViewInject(R.id.button01)
	private Button button01;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.button_item);
		
		ViewUtils.inject(this);
		button01.setVisibility(View.GONE);
		button.setText("点击发送消息");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EventBus.getDefault().post(new Data("tzw", 25));
				
			}
		});
	}

}
