package com.tjoven.customDialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class WindowDialogActivity extends BaseActivity{
	
	private Context context=WindowDialogActivity.this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button=(Button) findViewById(R.id.button01);
		button.setText("show DialogFragment");
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showStartWorkDialog();
				
			}
		});
	}
	private void showStartWorkDialog() {
		final AlertDialog dialog=new Builder(context).create();
		dialog.show();
		Window window=dialog.getWindow(); 
		window.setContentView(R.layout.my_main_dialog);
		Button cancleBtn=(Button) window.findViewById(R.id.cancle);
		Button okBtn=(Button) window.findViewById(R.id.ok);
		cancleBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showToast(context, "cancle");
				dialog.dismiss();
			}
		});
		okBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showToast(context, "ok");
				dialog.dismiss();
				
			}
		});
		
	}
}
