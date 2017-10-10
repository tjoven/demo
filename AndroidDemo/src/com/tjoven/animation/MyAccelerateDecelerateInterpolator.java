package com.tjoven.animation;

import android.animation.TimeInterpolator;
import android.util.Log;
import android.view.animation.Interpolator;

/**
 * 自定义插值器
 * @author car
 *
 */
public class MyAccelerateDecelerateInterpolator implements  Interpolator  {

	@Override
	public float getInterpolation(float input) {
		// TODO Auto-generated method stub
		Log.d("MyAccelerateDecelerateInterpolator", input+"");
		return input;
	}


}
