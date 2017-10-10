package com.example.state;

import android.content.Context;

public class LoginContext implements UserBehavior,UserState{
	static LoginContext loginContext;
	UserBehavior userBehavior=new OfflineState();// 默认离线
	public static LoginContext getInstance(){
		if (loginContext==null) {
			loginContext=new LoginContext();
		}
		return loginContext;
	}
	public void setState(UserBehavior userBehavior){
		this.userBehavior=userBehavior;
	}
	@Override
	public void forward(Context context) {
		userBehavior.forward( context);
		
	}
	@Override
	public void comment(Context context) {
		userBehavior.comment( context);
		
	}
	@Override
	public void onlineState() {
		setState(new OnlineState());
		
	}
	@Override
	public void offlineState() {
		setState(new OfflineState());
		
	}
}
