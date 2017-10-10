package com.tjoven.propertyAnimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class PropertyAnimation2 extends BaseActivity{
	
	ImageView imageView;
	private Context context=PropertyAnimation2.this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		imageView=(ImageView) findViewById(R.id.imageView);
	}
	@SuppressLint("NewApi")
	public void startAnim(View view) {
		// TODO Auto-generated method stub
		Animator animator= AnimatorInflater.loadAnimator(context, R.animator.scale);
		animator.setTarget(imageView);
		animator.start();
	}


}
