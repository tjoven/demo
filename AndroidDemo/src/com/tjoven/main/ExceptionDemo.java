package com.tjoven.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;








import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.tjove.ipcdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 抛异常 throw  throws
 * @author car
 *
 */
public class ExceptionDemo extends Activity implements InterfaceDemo{
	int i=1;
	
	@ViewInject(R.id.button01)
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);
		
		ExceptionDemo demo1=new ExceptionDemo();
//		demo1.regist(this);
		int age = 0;
		if (age<0) {
			RuntimeException exception=new RuntimeException("年龄不能为负数");
			throw exception;
		}
		
	}
	@OnClick({R.id.button01,R.id.text})
	private void onClick(View view){
		Toast.makeText(this, "xUtils", Toast.LENGTH_SHORT).show();
	}
	
	
	void regist(InterfaceDemo interfaceDemo){
		interfaceDemo.playDemo();
	}

	public void playA() {
		Log.v("tag", "playA");
		
	}

	@Override
	public void playDemo() {
		// TODO Auto-generated method stub
		Log.v("tag", "playDemo");
	}

}
