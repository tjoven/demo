package com.tjoven.listfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class FragmentActivity extends BaseActivity implements TranslateContentListener{
	RightFragement rightFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_activity);
		FragmentManager manager=getSupportFragmentManager();
		rightFragment=(RightFragement) manager.findFragmentById(R.id.right_fragment);
	}
	@Override
	public void translate(String city) {
		rightFragment.showContent(city);
	}
	interface ShowContentListener{
		void showContent(String title);
	}
}
