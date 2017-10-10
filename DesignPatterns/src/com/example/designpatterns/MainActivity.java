package com.example.designpatterns;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String url="http://images.csdn.net/20130609/zhuanti.jpg";
		ImageView imageView=(ImageView) findViewById(R.id.imageView);
		ImageLoader.displayImage(url, imageView);
	}
}

