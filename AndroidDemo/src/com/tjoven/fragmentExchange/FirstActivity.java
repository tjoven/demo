package com.tjoven.fragmentExchange;


import com.tjove.ipcdemo.R;
import com.tjoven.MVPframwork.LoginPresenter;

import android.util.Log;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ShareCompat.IntentBuilder;
import android.view.View;
import android.view.View.OnClickListener;

public class FirstActivity extends FragmentActivity {

	Context context=FirstActivity.this;
	FirstFragment firstFragment;
	FragmentManager manager=getSupportFragmentManager();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("FirstActivity","onCreate");
		setContentView(R.layout.fragment);
		findViewById(R.id.ll).setVisibility(View.VISIBLE);
		
		findViewById(R.id.button).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showFragment();
			}
		});
		
		findViewById(R.id.button02).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				exchangeFragment();
			}

			
		});
		
		manager.addOnBackStackChangedListener(new OnBackStackChangedListener() {
			
			@Override
			public void onBackStackChanged() {
				// TODO Auto-generated method stub
				Log.d("FirstActivity", "onBackStackChanged");
			}
		});
		
	}
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.d("FirstActivity","onRestoreInstanceState");
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("FirstActivity","onStart");
	}
	private void exchangeFragment() {
		// TODO Auto-generated method stub
		//一次操作，一次事务提交，所以要新建事务
		FragmentTransaction transaction=manager.beginTransaction();
		transaction.addToBackStack(null);
//		transaction.remove(firstFragment);
		transaction.hide(firstFragment);
		
		transaction.commit();
	}
	
	private void showFragment() {
		
		FragmentManager manager=getSupportFragmentManager();
		FragmentTransaction transaction=manager.beginTransaction();
		firstFragment=(FirstFragment) manager.findFragmentById(R.id.fragment);
		if (firstFragment==null) {
			firstFragment=new FirstFragment();
			transaction.add(R.id.fragment, firstFragment);
		}
		Bundle bundle=new Bundle();
		bundle.putString("argument", "argumentFromFirstActivity");
		firstFragment.setArguments(bundle);
		transaction.addToBackStack(null);//同返回键，撤销上一次提交的事物
		transaction.commit();
	}
}
