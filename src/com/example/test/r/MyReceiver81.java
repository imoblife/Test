package com.example.test.r;

import util.UmengUtil;

import com.example.test.MyService;
import com.example.test.c.MyControl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver81 extends BroadcastReceiver {
	private static final String TAG = MyReceiver81.class.getSimpleName();

	public void onReceive(Context context, Intent intent) {
		Log.i(getTag(), "onReceive()33:¡¡" + intent.getAction());
		MyControl.getInstance().onReceive(context, intent);
		MyService.start(context, intent.getAction());
		
		UmengUtil.checkUmeng(context, TAG);
	}

	public static String getTag() {
		return TAG;
	}
}
