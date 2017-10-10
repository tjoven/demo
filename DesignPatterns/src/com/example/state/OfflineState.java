package com.example.state;

import android.content.Context;
import android.content.Intent;

public class OfflineState implements UserBehavior{

	@Override
	public void forward(Context context) {
		Intent intent=new Intent();
		intent.setClass(context, LoginActivity.class);
		context.startActivity(intent);
		
	}

	@Override
	public void comment(Context context) {
		Intent intent=new Intent();
		intent.setClass(context, LoginActivity.class);
		context.startActivity(intent);
		
	}

}
