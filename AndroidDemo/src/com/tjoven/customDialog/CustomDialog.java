package com.tjoven.customDialog;

import com.tjove.ipcdemo.R;
import com.tjove.ipcdemo.R.layout;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomDialog extends Dialog{

	public CustomDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public CustomDialog(Context context, int theme) {
		super(context);
		// TODO Auto-generated method stub
	}
	
	public static class Builder{
		private Context context;
		private String title;
		private String content;
		private String postiveButtonText;
		private String negetiveButtonText;
		private View contentView;
		private DialogInterface.OnClickListener posiviteButtonClickListener;
		private DialogInterface.OnClickListener negativeButtonClickListener;
		
		public Builder(Context context) {
			this.context =context;
		}
		public Builder setMessage(String content){
			this.content=content;
			return this;
		}
		public Builder setTitle(String title){
			this.title=title;
			return this;
		}
		public Builder setPositiveButton(String postiveButtonText,DialogInterface.OnClickListener posiviteButtonClickListener){
			this.postiveButtonText=postiveButtonText;
			this.posiviteButtonClickListener=posiviteButtonClickListener;
			return this;
		}
		public Builder setNegativeButton(String negetiveButtonText,DialogInterface.OnClickListener negativeButtonClickListener){
			this.negetiveButtonText=negetiveButtonText;
			this.negativeButtonClickListener=negativeButtonClickListener;
			return this;
		}
		public Builder setContentView(View contentView){
			this.contentView=contentView;
			return this;
		}
		@SuppressLint("WrongViewCast")
		public CustomDialog create(){
			LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout=inflater.inflate(R.layout.dialog_normal, null);
			final CustomDialog dialog=new CustomDialog(context,R.style.Dialog);
			dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
			
			dialog.addContentView(layout, layoutParams);
			
			
			Button positiveButton=(Button)layout.findViewById(R.id.positiveButton);
			Button negativeButton=(Button)layout.findViewById(R.id.negativeButton);
		
			//posivite Button
			if (!TextUtils.isEmpty(postiveButtonText)) {
				positiveButton.setText(postiveButtonText);
				if (posiviteButtonClickListener!=null) {
					positiveButton.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							posiviteButtonClickListener.onClick(dialog, Dialog.BUTTON_POSITIVE);
							dialog.dismiss();
						}
					});
				}
			}else {
				positiveButton.setVisibility(View.GONE);
			}
			
			//negative Button
			if (!TextUtils.isEmpty(negetiveButtonText)) {
				negativeButton.setText(negetiveButtonText);
				if (negativeButtonClickListener!=null) {
					negativeButton.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							negativeButtonClickListener.onClick(dialog, Dialog.BUTTON_NEGATIVE);
							dialog.dismiss();
						}
					});
				}
			}else {
				negativeButton.setVisibility(View.GONE);
			}
			
			if (!TextUtils.isEmpty(content)) {
				((TextView)dialog.findViewById(R.id.content)).setText(content);
			}else if (contentView!=null) {
				((LinearLayout) layout.findViewById(R.id.content)).removeAllViews();  
				((LinearLayout) layout.findViewById(R.id.content)).addView(contentView, new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));  
			}
			
			if (!TextUtils.isEmpty(title)) {
				((TextView)layout.findViewById(R.id.title)).setText(title);
			}
			
			dialog.setContentView(layout);  
			return dialog;
			
		}
	}
	
}
