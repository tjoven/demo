package com.tjoven.singleSelectList;

import java.util.ArrayList;

import com.tjove.ipcdemo.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;

public class ItemAdapter<Content> extends BaseAdapter{

	Context context;
	Content content;
	int selectedPosition =-1;
	public ItemAdapter (Context context){
		this.context = context;
	}
	ArrayList<String> list;
	public void setData(ArrayList<String> list){
		this.list = list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.d("ItemAdapter", "getView"+position);
		View view=null;
		if(convertView==null){
			view = LayoutInflater.from(context).inflate(R.layout.item_radio, null);
		}else{
			view = convertView;
		}
		RadioButton radioButton = (RadioButton) view.findViewById(R.id.button);
		radioButton.setText(getItem(position).toString());
		if(selectedPosition == position){
			radioButton.setChecked(true);
		}else {
			radioButton.setChecked(false);
		}
		Log.d("adapter", "getView"+position);
		Log.d("adapter", "getView"+selectedPosition);
//		radioButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//				
//
//				
//			}
//		});
		radioButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("adapter", "onCheckedChanged"+position);
					selectedPosition = position;
					notifyDataSetChanged();
				
			}
		});
		return view;
	}

}
