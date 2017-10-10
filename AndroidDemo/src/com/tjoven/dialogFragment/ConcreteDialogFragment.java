package com.tjoven.dialogFragment;

import com.tjove.ipcdemo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class ConcreteDialogFragment extends DialogFragment{

	TranslateListener translateListener;
	@Override
	public void onAttach(Activity activity) {
		translateListener=(TranslateListener) activity;
		super.onAttach(activity);
	}

	public interface TranslateListener{
		void showMsg(String msg);
	}
//	@Override
//	public Dialog onCreateDialog(Bundle savedInstanceState) {
//		AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
//		LayoutInflater inflater=LayoutInflater.from(getActivity());
//		AlertDialog alertDialog=builder.setView(inflater.inflate(R.layout.dialog_fragment,null))
//				.setPositiveButton("Sign In", new OnClickListener() {
//					
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						translateListener.showMsg("translateListener");
//						Toast.makeText(getActivity(), "Sign In", Toast.LENGTH_SHORT).show();
//					}
//				}).create();
//		
//		
//		return alertDialog;
//	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.dialog_fragment,null);
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		Button button=(Button) view.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (getTargetFragment()!=null) {
					setResult();
				}
				ConcreteDialogFragment.this.dismiss();
				
			}

		});
		return view;
	}
	private void setResult() {
		Intent intent=new Intent();
		intent.putExtra("tag", "Fragment To Fragment");
		getTargetFragment().onActivityResult(0, 0, intent);
		
	}
	
}
