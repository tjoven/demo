package com.tjoven.main;

import com.lidroid.xutils.ViewUtils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity implements OnClickListener{

	int mScreenHeight;
	int mScreenWidth;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		DisplayMetrics outMetrics=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		mScreenHeight=outMetrics.heightPixels;
		mScreenWidth=outMetrics.widthPixels;
		Log.d(this.getClass().getSimpleName(), "mScreenHeight: "+mScreenHeight);
		Log.d(this.getClass().getSimpleName(), "mScreenWidth: "+mScreenWidth);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	public void showToast(Context context,String text){
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

}
