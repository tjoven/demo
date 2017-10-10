package com.example.main;

import java.util.ArrayList;

import com.example.designpatterns.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainAcitvity extends Activity{
	@ViewInject(R.id.listView)
	private ListView listView;
	
	ArrayList<Demo> arrayList;
	Context context =MainAcitvity.this;
private void addDatas() {
		
		arrayList.add(new Demo("中介者模式---登录界面", 
				com.example.mediator.LoginActivity.class));
		arrayList.add(new Demo("责任链模式---有序广播", 
				com.example.chainOfResponsibility.Client.class));
		arrayList.add(new Demo("设计准则-----ImageLoader", 
				com.example.designpatterns.MainActivity.class));
		arrayList.add(new Demo("状态模式-----在线/不在线 两种状态", 
				com.example.state.MainActivity.class));
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_list);
		
		ViewUtils.inject(this);//xUtils框架
		arrayList=new ArrayList<Demo>();
		
		BaseAdapter adapter=new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if (convertView==null) {
					convertView =LayoutInflater.from(context).inflate(R.layout.demo_info_item,null);
				}
				TextView textView=(TextView) convertView.findViewById(R.id.title);
				textView.setText(getItem(position).toString());
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
				return arrayList.get(position).title;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return arrayList.size();
			}
		};
		listView.setAdapter(adapter);
		addDatas();
		
		adapter.notifyDataSetChanged();
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent();
				intent.setClass(context, arrayList.get(position).class1);
				startActivity(intent);
				
			}
		});
	}
	
	class Demo{
		String title;
		Class class1;
		public Demo(String title, Class class1) {
			super();
			this.title = title;
			this.class1 = class1;
		}
		
	}
}
