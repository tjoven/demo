package com.tjoven.fragmentExchange;

import com.tjove.ipcdemo.R;
import com.tjoven.dialogFragment.ConcreteDialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondFragment extends Fragment {
	
	private final int REQUESTCODE=0;
	TextView textView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("SecondFragment", "onCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("SecondFragment", "onCreateView");
		View view = inflater.inflate(R.layout.activity_main, null);
		view.findViewById(R.id.button01).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent data = new Intent();
						data.putExtra("tag", "argumentFromSecondFragment");
						getActivity().setResult(0, data);
					}
				});
		textView=(TextView) view.findViewById(R.id.text);
		textView.setText("点击 展示dialogFragment");
		textView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//Fragment上面产生一个Fragment
				DialogFragmentOnSecondFragment dialogFragment = new DialogFragmentOnSecondFragment();
				FragmentManager manager = getFragmentManager();
				dialogFragment.setTargetFragment(SecondFragment.this, 0);
				dialogFragment.show(manager, "DialogFragmentOnSecondFragment");

			}
		});
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.d("SecondFragment", "onActivityCreated");
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("SecondFragment", "onStart");
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("SecondFragment", "onResume");
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("SecondFragment", "onPause");
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("SecondFragment", "onStop");
	}
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.d("SecondFragment", "onDestroyView");
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("SecondFragment", "onDestroy");
	}
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		Log.d("SecondFragment", "onDetach");
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		String request=data.getStringExtra("tag");
		if (!TextUtils.isEmpty(request)) {
			textView.setText(request);
		}
		Toast.makeText(getActivity(), request, Toast.LENGTH_SHORT).show();
	}
}
