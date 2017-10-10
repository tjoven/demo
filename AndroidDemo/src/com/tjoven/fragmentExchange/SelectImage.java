package com.tjoven.fragmentExchange;

import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class SelectImage extends BaseActivity{
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.select_image);
	ViewUtils.inject(this);
}
}
