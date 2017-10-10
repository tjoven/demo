package com.example.chainOfResponsibility;

import com.example.designpatterns.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Client extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
	}
	public void login(View v){
		Intent intent=new Intent();
		intent.setAction("com.example.chainOfResponsibility");
		Bundle bundle=new Bundle();
		bundle.putString("msg", "Client");
		bundle.putInt("limit", 100);
		intent.putExtras(bundle);
		sendOrderedBroadcast(intent, null);
	}
}
