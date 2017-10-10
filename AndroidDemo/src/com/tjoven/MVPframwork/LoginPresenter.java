package com.tjoven.MVPframwork;

import android.os.Handler;

public class LoginPresenter {
	ILoginView iLoginView;
	UserOpera opera=new UserOpera();
	
	Handler handler=new Handler();
	
	public LoginPresenter(ILoginView iLoginView) {
		this.iLoginView=iLoginView;
	}
	
	public void login(){
		opera.login(iLoginView.getName(), iLoginView.getPassWord(), new OnLoginLostener() {
			
			@Override
			public void success() {
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						iLoginView.showSuccess();
						
					}
				});
				
			}
			
			@Override
			public void failed() {
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						iLoginView.showFailed();
						
					}
				});
				
			}
		});
	}
	
	public void clear() {
		
	}
}
