package com.example.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver2 extends BroadcastReceiver {
	private static final String TAG = MyReceiver2.class.getSimpleName();

	public void onReceive(Context context, Intent intent) {
		Log.i(getTag(), "onReceive():¡¡" + intent.getAction());
		MyService.start(context, intent.getAction());
	}

	public static String getTag() {
		return TAG;
	}
}
