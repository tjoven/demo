package com.tjoven.MVPframwork;

public class UserOpera implements IUserOpera{

	User user=new User();
	
	@Override
	public void login(final String name, final String passWord, final OnLoginListener listener) {

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					if (name.equals("tzw")&&passWord.equals("123")) {
						user.name=name;
						user.passWord=passWord;
						listener.success();
					}else {
						listener.failed();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	
		
	}
	
}
