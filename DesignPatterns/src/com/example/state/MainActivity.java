package com.example.state;

import com.example.designpatterns.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
/**
 * 状态模式 实战
 * 模仿 微博登录 分为用户 已登录/未登录 两种状态
 * @author car
 *
 */
public class MainActivity extends Activity {
	Context context=MainActivity.this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_main_activity);
		
	}

	public  void forward(View view) {
		LoginContext.getInstance().forward(context);

	}

	public void comment(View view) {
		LoginContext.getInstance().comment(context);

	}

}
