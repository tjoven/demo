package com.tjoven.grideView;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

public class GrideViewDemo extends BaseActivity{
	
	@ViewInject(R.id.gridView)
	private GridView gridView;
	
	ArrayList<Bean> list;
	Context context=GrideViewDemo.this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gride_view);
		ViewUtils.inject(this);
		
		list=new ArrayList<Bean>();
		for (int i = 0; i < 7; i++) {
			list.add(new Bean(null, "你好"));
		}
		
		BaseAdapter adapter=new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if (convertView==null) {
					convertView=LayoutInflater.from(context).inflate(R.layout.grid_view_item, null); 
				}
				TextView textView=(TextView) convertView.findViewById(R.id.textView);
				RelativeLayout relativeLayout=(RelativeLayout) convertView.findViewById(R.id.rl);
				
				String name=((Bean)getItem(position)).name;
				textView.setText(name);
				return convertView;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return list.get(position);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return list.size();
			}
		};
		
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				showToast(context, list.get(position).name+position);
				
			}
		});
	}
class Bean{
	String imagePath;
	String name;
	public Bean(String imagePath, String name) {
		super();
		this.imagePath = imagePath;
		this.name = name;
	}
}
}
