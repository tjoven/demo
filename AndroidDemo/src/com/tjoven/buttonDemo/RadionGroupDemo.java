package com.tjoven.buttonDemo;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class RadionGroupDemo extends BaseActivity{
	@ViewInject(R.id.radioButton1)
	private RadioButton radioButton1;
	@ViewInject(R.id.radioButton2)
	private RadioButton radioButton2;
	@ViewInject(R.id.radioButton3)
	private RadioButton radioButton3;
	@ViewInject(R.id.toggleButton1)
	private ToggleButton toggleButton1;
	@ViewInject(R.id.toggleButton2)
	private ToggleButton toggleButton2;
	@ViewInject(R.id.EditText)
	private EditText editText;
	Context context=RadionGroupDemo.this;
	private String TAG=RadionGroupDemo.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radion_group_view);
		ViewUtils.inject(this);
		bindView();
	}
	private void bindView() {
		toggleButton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "nihao:"+editText.getText().toString(), Toast.LENGTH_SHORT).show();
				
			}
		});
		InputFilter[] inputFilters=new InputFilter[1];
		inputFilters[0] = new InputFilter() {
			@Override
			public CharSequence filter(CharSequence source, int start, int end,
					Spanned dest, int dstart, int dend) {
				Log.d(TAG, "source: "+source);
				Log.d(TAG, "start: "+start);
				Log.d(TAG, "end"+end);
				Log.d(TAG, "dest: "+dest);
				Log.d(TAG, "dstart: "+dstart);
				Log.d(TAG, "dend: "+dend);
				String mDestString = dest.toString();
				String result = dest.subSequence(0, dstart) + source.toString()
						+ dest.subSequence(dend, mDestString.length());
				int intBit = 0;
				if (result.contains(".")) {
					if (result.equals(".")) {
						return "0.";
					}
					int pointIndex = result.indexOf(".");
					if (result.length() - pointIndex - 1 > 1) {
						return "";
					}
					intBit = pointIndex;
				} else {
					intBit = result.length();
				}
				if (intBit > 5) {
					return "";
				}
				return null;
			}
		};
		editText.setFilters(inputFilters);
	}

}
