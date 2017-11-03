package com.tjoven.MVPframwork;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

/**
 * MVP模式
 * @author car
 *
 */
public class MVPActivity extends BaseActivity implements ILoginView{
	
	@ViewInject(R.id.name_edit)
	private EditText nameEdit;
	@ViewInject(R.id.password_edit)
	private EditText passwordEdit;
	@ViewInject(R.id.login_bt)
	private Button loginBt;
	@ViewInject(R.id.clear_bt)
	private Button clearBt;
	
	LoginPresenter presenter;
	Context context=MVPActivity.this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		ViewUtils.inject(this);
		
		initView();
		
		presenter=new LoginPresenter(this);
		
	}

	private void initView() {
		
		loginBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				presenter.login();
				
			}
		});
		
		clearBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				presenter.clear();
				
			}
		});
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nameEdit.getText().toString();
	}

	@Override
	public String getPassWord() {
		// TODO Auto-generated method stub
		return passwordEdit.getText().toString();
	}

	@Override
	public void showSuccess() {
		showToast(context, "showSucess");
		
	}

	@Override
	public void showFailed() {
		showToast(context, "showFailed");
		
	}

}
