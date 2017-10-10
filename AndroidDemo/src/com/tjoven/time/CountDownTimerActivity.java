package com.tjoven.time;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class CountDownTimerActivity extends BaseActivity{

	TextView textView;
	Button button;
	CountDownTimer countDownTimer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView=(TextView) findViewById(R.id.text);
		button=(Button) findViewById(R.id.button01);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				countDownTimer.cancel();
			}
		});
		//10000---倒计时时间，1,----倒计时 时间间隔
		countDownTimer=new CountDownTimer(10000, 1) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				textView.setText(millisUntilFinished/1000+"");
			}
			
			@Override
			public void onFinish() {
				textView.setText("over");
			}
		};
		countDownTimer.start();
	}
}
