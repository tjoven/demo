package com.tjoven.propertyAnimation;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class ValuesHolderKeyFrame extends BaseActivity{
	ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		imageView = (ImageView) findViewById(R.id.imageView);
	
	}
	@SuppressLint("NewApi")
	public void startAnim(View view) {
		// TODO Auto-generated method stub
		Keyframe keyframe0 = Keyframe.ofFloat(0.0f, 0f);
//		keyframe0.setInterpolator(new LinearInterpolator());
		Keyframe keyframe1 = Keyframe.ofFloat(0.1f, 100f);
		Keyframe keyframe2 = Keyframe.ofFloat(0.2f, 200);
		Keyframe keyframe3 = Keyframe.ofFloat(1f, 500f);
		PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("translationX", keyframe0,keyframe1,keyframe2,keyframe3);
		ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, holder);
		animator.setDuration(3000);
		animator.start();
	}

}
