package com.tjoven.loader;

import com.tjove.ipcdemo.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


public class NetWorkLoaderActivity extends FragmentActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		FragmentManager fragmentManager = getSupportFragmentManager();
		if (fragmentManager.findFragmentById(android.R.id.content)==null) {
			fragmentManager.beginTransaction().add(android.R.id.content, new NetWorkLoaderFragment()).commit();
		}
	}
}
