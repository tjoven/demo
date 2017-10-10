package com.tjoven.customView;


import com.tjove.ipcdemo.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AttrsDemo extends LinearLayout{
	
	public AttrsDemo(Context context) {
		this(context,null);

	}
	public AttrsDemo(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.AttrsDemo);
		int textColor=typedArray.getColor(R.styleable.AttrsDemo_textColor,  0XFFFFFFFF);
		float textSize=typedArray.getDimension(R.styleable.AttrsDemo_textSize, 18);
		typedArray.recycle();
		
		View view=LayoutInflater.from(context).inflate(R.layout.text_view_itme, null);
		TextView textView=(TextView)view.findViewById(R.id.text);
		textView.setText("hello world");
		textView.setTextColor(textColor);
		textView.setTextSize(textSize);
		addView(view); 	
	}

}
