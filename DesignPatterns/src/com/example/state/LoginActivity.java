package com.example.state;

import com.example.designpatterns.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
	EditText name;
	EditText password;
	
	Context context=LoginActivity.this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		
		name=(EditText) findViewById(R.id.name_edit);
		password=(EditText) findViewById(R.id.password_edit);
		
	}
	public void login(View view){
		Toast.makeText(context, name.getText().toString(), Toast.LENGTH_SHORT).show();
		if (name.getText().toString().equals("123")) {
			LoginContext.getInstance().onlineState();
			Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
			finish();
		}else {
			LoginContext.getInstance().offlineState();
			Toast.makeText(context, "登录失败",Toast.LENGTH_SHORT).show();
			finish();
		}
	}
}
