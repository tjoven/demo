package com.tjoven.fragmentExchange;


import com.tjove.ipcdemo.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FirstActivity extends FragmentActivity {

	Context context=FirstActivity.this;
	FirstFragment firstFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment);
		FragmentManager manager=getSupportFragmentManager();
		firstFragment=(FirstFragment) manager.findFragmentById(R.id.fragment);
		FragmentTransaction transaction=manager.beginTransaction();
		if (firstFragment==null) {
			firstFragment=new FirstFragment();
			transaction.add(R.id.fragment, firstFragment);
		}
		Bundle bundle=new Bundle();
		bundle.putString("argument", "argumentFromFirstActivity");
		firstFragment.setArguments(bundle);
		transaction.commit();
	}
}
