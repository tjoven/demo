package com.example.chainOfResponsibility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FirstReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		int limit=intent.getIntExtra("limit", 0);
		String msg=intent.getStringExtra("msg");
		
		
		Bundle bundl=getResultExtras(false);
		if (limit==100) {
			Toast.makeText(context, msg+"FirstReceiver"+bundl.getString("new"), Toast.LENGTH_SHORT).show();
			abortBroadcast();
		}
		
	}

}
