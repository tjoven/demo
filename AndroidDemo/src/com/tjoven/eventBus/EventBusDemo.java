package com.tjoven.eventBus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tjove.ipcdemo.R;
import com.tjoven.main.BaseActivity;

import de.greenrobot.event.EventBus;
/**
 *  onEvent:如果使用onEvent作为订阅函数，那么该事件在哪个线程发布出来的，onEvent就会在这个线程中运行，也就是说发布事件和接收事件线程在同一个线程。使用这个方法时，在onEvent方法中不能执行耗时操作，如果执行耗时操作容易导致事件分发延迟。
	onEventMainThread:如果使用onEventMainThread作为订阅函数，那么不论事件是在哪个线程中发布出来的，onEventMainThread都会在UI线程中执行，接收事件就会在UI线程中运行，这个在Android中是非常有用的，因为在Android中只能在UI线程中跟新UI，所以在onEventtMainThread方法中是不能执行耗时操作的。
	onEventBackground:如果使用onEventBackgrond作为订阅函数，那么如果事件是在UI线程中发布出来的，那么onEventBackground就会在子线程中运行，如果事件本来就是子线程中发布出来的，那么onEventBackground函数直接在该子线程中执行。
	onEventAsync：使用这个函数作为订阅函数，那么无论事件在哪个线程发布，都会创建新的子线程在执行onEventAsync.
 * @author car
 *
 */
public class EventBusDemo extends BaseActivity{
	@ViewInject(R.id.button01)
	private Button button;
	@ViewInject(R.id.text)
	private TextView textView;
	
	Context context=EventBusDemo.this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ViewUtils.inject(this);
		EventBus.getDefault().register(this);
		textView.setText("EventBusDemo准备接受来自总线的消息");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(context, SecondEventBus.class);
				startActivity(intent);
				
			}
		});
	}
	/*
	 * EventBus是怎么接收消息的，是根据参数中类的实例的类型的判定的，所以当如果我们在接收时，同一个类的实例参数有两个函数来接收会怎样？答案是，这两个函数都会执行
	 * @param event
	 */
	public void onEventMainThread(Data event){
		System.out.println("onEventMainThread"+event.name+": "+event.age);
		System.out.println(Thread.currentThread().getName());
		textView.setText(event.age+"");
		showToast(context, "年龄： "+event.name);
	}
	public void onEventBackgroundThread(Data event){
		System.out.println("onEventBackgroundThread"+event.name+": "+event.age);
		System.out.println(Thread.currentThread().getName());
		textView.setText(event.age+"");
		showToast(context, "年龄： "+event.name);
	}
	public void onEventAsync(Data event){
		System.out.println("onEventAsync"+event.name+": "+event.age);
		System.out.println(Thread.currentThread().getName());
		textView.setText(event.age+"");
		showToast(context, "年龄： "+event.name);
	}
	public void onEvent(Data event){
		System.out.println("onEvent"+event.name+": "+event.age);
		System.out.println(Thread.currentThread().getName());
		textView.setText(event.age+"");
		showToast(context, "年龄： "+event.name);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
}
