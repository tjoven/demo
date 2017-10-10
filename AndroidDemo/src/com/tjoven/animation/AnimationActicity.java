package com.tjoven.animation;

import com.android.volley.toolbox.NetworkImageView;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * XML实现
 * @author car
 *
 */
public class AnimationActicity extends BaseActivity{
	android.view.animation.Animation animation;
	private ImageView imageView;
	private NetworkImageView network_iv;

	private static final int animationRotate=0;
	private static final int animationTranslate=1;
	private static final int animationScale=2;
	private static final int animationAlpha=3;
	
	private String TAG = AnimationActicity.class.getSimpleName();
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
			animation=AnimationUtils.loadAnimation(AnimationActicity.this, R.anim.r);
			network_iv.startAnimation(animation);
			break;
		case animationTranslate:
			animation=AnimationUtils.loadAnimation(AnimationActicity.this, R.anim.translate);
			imageView.startAnimation(animation);
			animation.setAnimationListener(new AnimationListener() {
				
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
			break;
		case animationScale:
			animation=AnimationUtils.loadAnimation(AnimationActicity.this, R.anim.scale);
			imageView.startAnimation(animation);
			break;
		case animationAlpha:
			animation=AnimationUtils.loadAnimation(AnimationActicity.this, R.anim.alpha);
			imageView.startAnimation(animation);
			break;

		default:
			break;
		
		}
		return super.onOptionsItemSelected(item);
	}

}
