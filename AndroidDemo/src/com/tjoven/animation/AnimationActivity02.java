package com.tjoven.animation;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.android.volley.toolbox.NetworkImageView;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

/**
 * 代码实现
 * @author car
 *
 */
public class AnimationActivity02 extends BaseActivity{
	android.view.animation.Animation animation;
	private ImageView imageView;
	private NetworkImageView network_iv;

	private static final int animationRotate=0;
	private static final int animationTranslate=1;
	private static final int animationScale=2;
	private static final int animationAlpha=3;
	
	ScaleAnimation scaleAnimation= null;  
    TranslateAnimation translateAnimation= null;  
    RotateAnimation rotateAnimation= null;  
    AlphaAnimation  alphaAnimation  = null;
    private String TAG=AnimationActivity02.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_view);
		imageView=(ImageView) findViewById(R.id.imageView);
		network_iv=(NetworkImageView) findViewById(R.id.network_iv);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(animationRotate, animationRotate, animationRotate, "animationRotate");
		menu.add(animationTranslate, animationTranslate, animationTranslate, "animationTranslate");
		menu.add(animationScale, animationScale, animationScale, "animationScale");
		menu.add(animationAlpha, animationAlpha, animationAlpha, "animationAlpha");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case animationRotate:
			// 构建一个旋转动画  
            AnimationSet animationset = new AnimationSet(true);  
            rotateAnimation = new RotateAnimation(0.0f, 360.0f,    
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,  // 注意参数是百分比  
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);  
            rotateAnimation.setDuration(3000);  
            rotateAnimation.setFillAfter(true);
            animationset.addAnimation(rotateAnimation);  //添加多个动画，动画组合
            network_iv.startAnimation(animationset);
			break;
		case animationTranslate:
			 // 创建一个画面位置移动的动画  
            animationset = new AnimationSet(true);  
            translateAnimation = new TranslateAnimation(  
                    Animation.RELATIVE_TO_SELF, 0.3f,  // 注意参数  
                    Animation.RELATIVE_TO_SELF, 1.0f,  
                    Animation.RELATIVE_TO_SELF, 0.4f,  
                    Animation.RELATIVE_TO_SELF, 1.0f);  
            translateAnimation.setDuration(5000);  
            animationset.setFillAfter(true);//外面有一层 set，所以这个一定要在set的属性里设置
            translateAnimation.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {
					Log.d(TAG, "X坐标："+imageView.getX());
					Log.d(TAG, "Y坐标："+imageView.getY());
					
				}
				
				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animation animation) {
					Log.d(TAG, "X坐标："+imageView.getX());
					Log.d(TAG, "Y坐标："+imageView.getY());
					
				}
			});
            animationset.addAnimation(translateAnimation);  
            imageView.startAnimation(animationset); 
			break;
		case animationScale:
			// 创建缩放动画,时间0.5s  
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 2.0f, Animation.RELATIVE_TO_SELF,  
                    0.5f, Animation.RELATIVE_TO_SELF, 0.5f);  
            scaleAnimation.setDuration(5000);  
            scaleAnimation.setFillAfter(true);
            imageView.startAnimation(scaleAnimation);
			break;
		case animationAlpha:
			// 创建透明像素动画，时间3s  
            alphaAnimation = new AlphaAnimation(0.1f, 1.0f);  
            alphaAnimation.setDuration(3000);  
            alphaAnimation.setFillAfter(true);
            imageView.startAnimation(alphaAnimation); 
			break;

		default:
			break;
		
		}
		return super.onOptionsItemSelected(item);
	}

}
