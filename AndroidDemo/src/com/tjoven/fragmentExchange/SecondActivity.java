package com.tjoven.fragmentExchange;


import com.tjove.ipcdemo.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class SecondActivity extends FragmentActivity {

	SecondFragment secondFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment);
		FragmentManager manager=getSupportFragmentManager();
		secondFragment=(SecondFragment) manager.findFragmentById(R.id.fragment);
		FragmentTransaction transaction=manager.beginTransaction();
		if (secondFragment==null) {
			secondFragment=new SecondFragment();
			transaction.add(R.id.fragment, secondFragment);
		}
		transaction.commit();
		
	}

}
