package com.tjoven.listfragment;

import com.tjove.ipcdemo.R;
import com.tjoven.listfragment.FragmentActivity.ShowContentListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RightFragement extends Fragment implements ShowContentListener{
	TextView textView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.text_view_itme, null);
		textView=(TextView) view.findViewById(R.id.text);
		return view;
	}
	@Override
	public void showContent(String title) {
		textView.setText(title);
	}
}
