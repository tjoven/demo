package com.example.state;

import android.content.Context;

public interface UserBehavior {
	void forward(Context context);
	void comment(Context context);
}
