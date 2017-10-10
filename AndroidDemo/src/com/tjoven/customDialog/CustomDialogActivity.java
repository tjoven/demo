package com.tjoven.customDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class CustomDialogActivity extends BaseActivity {
	private Context context = CustomDialogActivity.this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button=(Button) findViewById(R.id.button01);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CustomDialog.Builder builder=new CustomDialog.Builder(context);
				builder.setTitle("提示");
				builder.setMessage("内容");
				builder.setPositiveButton("确定", new android.content.DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						showToast(context, "PositiveButton");
					}
				});
				builder.create().show();
			}
		});
		
	}
}
