package com.tjoven.fragmentExchange;

import com.tjove.ipcdemo.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FirstFragment extends Fragment{
	TextView textView;
	String argument;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle bundle=getArguments();
		argument=bundle.getString("argument");
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =inflater.inflate(R.layout.activity_main, null);
		textView=(TextView) view.findViewById(R.id.text);
		textView.setText(argument);
		view.findViewById(R.id.button01).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(getActivity(), SecondActivity.class);
				startActivityForResult(intent, 0);
			}
		});
		return view;
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if (data==null) {
			textView.setText("null");
			return;
		}
		String dateString=data.getStringExtra("tag");
		textView.setText(dateString);
	}
}
