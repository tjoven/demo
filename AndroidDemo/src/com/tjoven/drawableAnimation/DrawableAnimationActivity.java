package com.tjoven.drawableAnimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class DrawableAnimationActivity extends BaseActivity{
	@ViewInject(R.id.button01)
	private Button button;
	@ViewInject(R.id.imageView2)
	private ImageView imageView;
	
	AnimationDrawable animationDrawable;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		ViewUtils.inject(this);
		imageView.setBackgroundResource(R.drawable.drawable_animation);
		animationDrawable=(AnimationDrawable) imageView.getDrawable();
	}
	
	public void startAnim(View view) {
		animationDrawable.start();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		animationDrawable.start();
	} 	
}
