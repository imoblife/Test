package com.example.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
	private static final String TAG = MyReceiver.class.getSimpleName();

	public void onReceive(Context context, Intent intent) {
		Log.i(getTag(), "onReceive():��" + intent.getAction());
		MyService.start(context, intent.getAction());
	}

	public static String getTag() {
		return TAG;
	}
}
