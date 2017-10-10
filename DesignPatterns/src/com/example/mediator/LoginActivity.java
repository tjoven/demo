package com.example.mediator;

import com.example.designpatterns.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
	@ViewInject(R.id.name_edit)
	private EditText nameEdit;
	@ViewInject(R.id.password_edit)
	private EditText passwordEdit;
	@ViewInject(R.id.bt_saveAccount)
	private CheckBox saveAccountBt;
	@ViewInject(R.id.bt_autoLog)
	private CheckBox autoLogBt;
	@ViewInject(R.id.login_bt)
	private Button loginBt;
	@ViewInject(R.id.clear_bt)
	private Button clearBt;
	
	String account;
	String password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		ViewUtils.inject(this);
		
		account=nameEdit.getText().toString();
		password=passwordEdit.getText().toString();
		loginBt.setEnabled(false);
		clearBt.setEnabled(true);
		
		saveAccountBt.setEnabled(false);
		autoLogBt.setEnabled(false);
		
		passwordEdit.setEnabled(false);
		bindListener();
	}
	/**
	 * 相当于 中介的处理
	 */
	private void change() {
		if (TextUtils.isEmpty(account)) {
			loginBt.setEnabled(false);
			clearBt.setEnabled(true);
			
			saveAccountBt.setEnabled(false);
			autoLogBt.setEnabled(false);
			
			passwordEdit.setEnabled(false);
		}else if (!TextUtils.isEmpty(account)&&TextUtils.isEmpty(password)) {
			passwordEdit.setEnabled(true);
			autoLogBt.setEnabled(false);
			saveAccountBt.setEnabled(true);
			
			loginBt.setEnabled(false);
			clearBt.setEnabled(true);
		}else if (!TextUtils.isEmpty(account)&&!TextUtils.isEmpty(password)) {
			passwordEdit.setEnabled(true);
			autoLogBt.setEnabled(true);
			saveAccountBt.setEnabled(true);
			
			loginBt.setEnabled(true);
			clearBt.setEnabled(true);
		}
		
		if (autoLogBt.isChecked()) {
			saveAccountBt.setChecked(true);
		}
		
	}
	private void bindListener() {
		nameEdit.setTag("nameEdit");
		nameEdit.addTextChangedListener(new EditChangeListener(nameEdit));
		passwordEdit.setTag("passwordEdit");
		passwordEdit.addTextChangedListener(new EditChangeListener(passwordEdit));
		saveAccountBt.setOnCheckedChangeListener(new CheckBoxClickListener());
		autoLogBt.setOnCheckedChangeListener(new CheckBoxClickListener());
		loginBt.setOnClickListener(new ButtonClickListener("登录成功"));
		clearBt.setOnClickListener(new ButtonClickListener("取消登录"));
		
	}
	class ButtonClickListener implements OnClickListener{

	    String msg;
		public ButtonClickListener( String msg) {
			this.msg=msg;
		}
		@Override
		public void onClick(View v) {
			Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
			
		}
		
	}
	class CheckBoxClickListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			change();
			
		}
		
	}
	class EditChangeListener implements TextWatcher{
		EditText editText;
        public EditChangeListener(EditText editText) {
			this.editText=editText;
		}
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			if (editText.getTag().equals("nameEdit")) {
				account=s.toString();
			}else if (editText.getTag().equals("passwordEdit")) {
				password=s.toString();
			}
			change();
			
		}
		
	}

}
