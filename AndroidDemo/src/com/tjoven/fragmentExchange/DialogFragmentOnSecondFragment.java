package com.tjoven.fragmentExchange;

import com.tjove.ipcdemo.R;
import com.tjoven.dialogFragment.ConcreteDialogFragment;
import com.tjoven.dialogFragment.ConcreteDialogFragment.TranslateListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogFragmentOnSecondFragment extends DialogFragment{

	String returnString="Fragment To Fragment";
	EditText editText;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view=inflater.inflate(R.layout.dialog_fragment,null);
		
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		Button button=(Button) view.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (getTargetFragment()!=null) {
					setResult(view);
				}
				DialogFragmentOnSecondFragment.this.dismiss();
			}

		});
		return view;
	}
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		Toast.makeText(getActivity(), "DialogFragment的宿主activity是 "+activity.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
	}
	private void setResult(View view) {
		Intent intent=new Intent();
		editText=(EditText) view.findViewById(R.id.name_ed);
		if (!TextUtils.isEmpty(editText.getText().toString())) {
			returnString=editText.getText().toString();
		}
		intent.putExtra("tag", returnString);
		getTargetFragment().onActivityResult(0, 0, intent);
		
	}
	
}
