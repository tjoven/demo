package com.tjoven.MVPframwork;

public interface IUserOpera {
	void login(String name,String passWord,OnLoginLostener listener);
}
