package com.tjoven.dialogFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.tjove.ipcdemo.R;
import com.tjoven.dialogFragment.ConcreteDialogFragment.TranslateListener;
import com.tjoven.main.BaseActivity;

public class DialogFragmentActivity extends BaseActivity implements TranslateListener{
	@Override
	public void showMsg(String msg) {
		showToast(this, msg);
	}
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
				ConcreteDialogFragment dialogFragment=new ConcreteDialogFragment();
				FragmentManager manager=getSupportFragmentManager();
				dialogFragment.show(manager, "DialogFragmentActivity");
				
			}
		});
	}
}
