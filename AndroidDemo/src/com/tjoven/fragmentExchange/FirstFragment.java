package com.tjoven.fragmentExchange;

import com.tjove.ipcdemo.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
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
		Log.d("FirstFragment", "onCreate");
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("FirstFragment", "onCreateView");
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
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.d("FirstFragment", "onActivityCreated");
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("FirstFragment", "onStart");
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("FirstFragment", "onResume");
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("FirstFragment", "onPause");
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("FirstFragment", "onStop");
	}
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.d("FirstFragment", "onDestroyView");
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("FirstFragment", "onDestroy");
	}
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		Log.d("FirstFragment", "onDetach");
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
