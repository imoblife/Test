package com.example.test;

import com.example.test.c.MyControl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver2 extends BroadcastReceiver {
	private static final String TAG = MyReceiver2.class.getSimpleName();

	public void onReceive(Context context, Intent intent) {
		Log.i(getTag(), "onReceive()11:¡¡" + intent.getAction());
		MyControl.getInstance().onReceive(context, intent);
		MyService.start(context, intent.getAction());
	}

	public static String getTag() {
		return TAG;
	}
}
