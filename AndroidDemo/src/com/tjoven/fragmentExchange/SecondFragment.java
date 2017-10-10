package com.tjoven.fragmentExchange;

import com.tjove.ipcdemo.R;
import com.tjoven.dialogFragment.ConcreteDialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
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
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
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
