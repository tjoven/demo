package com.tjoven.propertyAnimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class ObjectAnimActivity extends BaseActivity{
	ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		imageView=(ImageView) findViewById(R.id.imageView);
	}
	
	@SuppressLint("NewApi")
	public void startAnim(View view) {
		//内部通过反射查找 属性名对应的set/get方法，如果找不到属性名，可以手动调用addUpdateListener方法实现动画,
		//当然也可以自定义为view添加属性的set、get方法
		ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotationX", 0.0f,360.0f);
		animator.setDuration(3000);
		animator.start();
		imageView.setPivotX(0);
		animator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// TODO Auto-generated method stub
				float rotation=(Float) animation.getAnimatedValue();
				imageView.setRotationX(rotation);
				Log.d(ObjectAnimActivity.class.getName(), "旋转角度"+rotation);
				Log.d(ObjectAnimActivity.class.getName(), "view的高度"+imageView.getMeasuredHeight());
				Log.d(ObjectAnimActivity.class.getName(), "view的X坐标"+imageView.getX());
			}
		});
		
		PropertyValuesHolder alpha=PropertyValuesHolder.ofFloat("alpha", 1.0f,0.0f);
		PropertyValuesHolder scaleX=PropertyValuesHolder.ofFloat("scaleX", 1.0f,0.0f);
		PropertyValuesHolder scaleY=PropertyValuesHolder.ofFloat("scaleY", 1.0f,0.0f);
		ObjectAnimator animator2=ObjectAnimator.ofPropertyValuesHolder(imageView,alpha, scaleX,scaleY);
//		animator2.setDuration(2000).start();
		
		ValueAnimator valueAnimator=new ValueAnimator();
		valueAnimator.setDuration(3000);
		valueAnimator.setObjectValues(new PointF(0,0));
//		valueAnimator.start();
		valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {

			@Override
			public PointF evaluate(float fraction, PointF startValue,
					PointF endValue) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		AnimatorSet animatorSet=new AnimatorSet();
		animatorSet.playTogether(animator,animator2);
//		animatorSet.start();
		

	}
	
	

}
