package com.tjoven.main;
import java.util.ArrayList;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.annotation.AnnotationDemo;
import com.tjoven.customView.CustomView;
import com.tjoven.eventBus.EventBusDemo;
import com.tjoven.fragmentExchange.SelectImage;
import com.tjoven.grideView.GrideViewDemo;
import com.tjoven.memoryLeak.MemoryLeak;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	@ViewInject(R.id.listView)
	private ListView listView;
	
	ArrayList<Demo> arrayList;
	
	private void addDatas() {
	
		arrayList.add(new Demo("EmojiDemo",com.tjoven.emoji.EmojiDemo.class));
		arrayList.add(new Demo("NetWorkLoaderActivity",com.tjoven.loader.NetWorkLoaderActivity.class));
		arrayList.add(new Demo("SearchViewDemo",com.tjoven.searchView.SearchViewDemo.class));
		arrayList.add(new Demo("CustomView", CustomView.class));//自定义控件
		arrayList.add(new Demo("ExceptionDemo", ExceptionDemo.class));//抛异常
		arrayList.add(new Demo("AnnotationDemo", AnnotationDemo.class));//添加注释
		arrayList.add(new Demo("MemoryLeak", MemoryLeak.class));//添加注释
		arrayList.add(new Demo("SelectImage", SelectImage.class));//在xml中 定义图片的多种状态
		arrayList.add(new Demo("GrideViewDemo", GrideViewDemo.class));//gridView
		arrayList.add(new Demo("EventBusDemo", EventBusDemo.class));//事件总线
		arrayList.add(new Demo("MVPActivity", com.tjoven.MVPframwork.MVPActivity.class));//MVP模式
		arrayList.add(new Demo("DialogFragmentActivity", com.tjoven.dialogFragment.DialogFragmentActivity.class));//DialogFragment弹出框
		arrayList.add(new Demo("ListFragmentActivity", com.tjoven.listfragment.FragmentActivity.class));
		arrayList.add(new Demo("SpannableStringDemo", com.tjoven.spannable.SpannableStringDemo.class));
		arrayList.add(new Demo("SocketClient", com.tjoven.socket.SocketClient.class));
		arrayList.add(new Demo("WindowDialogActivity", com.tjoven.customDialog.WindowDialogActivity.class));
		arrayList.add(new Demo("CustomDialogActivity", com.tjoven.customDialog.CustomDialogActivity.class));
		arrayList.add(new Demo("TimeActivity", com.tjoven.time.TimeActivity.class));
		arrayList.add(new Demo("CountDownTimerActivity", com.tjoven.time.CountDownTimerActivity.class));
		arrayList.add(new Demo("AnimationActicity", com.tjoven.animation.AnimationActicity.class));
		arrayList.add(new Demo("AnimationActicity02", com.tjoven.animation.AnimationActivity02.class));
		arrayList.add(new Demo("fragmentExchange", com.tjoven.fragmentExchange.FirstActivity.class));
		arrayList.add(new Demo("StringRequestDemo", com.tjoven.volley.StringRequestDemo.class));
		arrayList.add(new Demo("ImageRequestDemo", com.tjoven.volley.ImageRequestDemo.class));
		arrayList.add(new Demo("ExceptionDemo", com.tjoven.main.ExceptionDemo.class));
		arrayList.add(new Demo("propertyAnimation",com.tjoven.propertyAnimation.ObjectAnimActivity.class));
		arrayList.add(new Demo("ValuesHolder  KeyFrame",com.tjoven.propertyAnimation.ValuesHolderKeyFrame.class));
		arrayList.add(new Demo("PropertyAnimation2",com.tjoven.propertyAnimation.PropertyAnimation2.class));
		arrayList.add(new Demo("LayoutTransitionActivity",com.tjoven.propertyAnimation.LayoutTransitionActivity.class));
		arrayList.add(new Demo("DrawableAnimationActivity",com.tjoven.drawableAnimation.DrawableAnimationActivity.class));
		arrayList.add(new Demo("RadionGroupDemo",com.tjoven.buttonDemo.RadionGroupDemo.class));
		
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
					convertView =LayoutInflater.from(MainActivity.this).inflate(R.layout.demo_info_item,null);
				}
				TextView textView=(TextView) convertView.findViewById(R.id.title);
				textView.setText(getItem(position)+"");
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
				intent.setClass(MainActivity.this, arrayList.get(position).class1);
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
