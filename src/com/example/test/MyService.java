package com.example.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.test.c.MyControl;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class MyService extends Service {
	private static final String TAG = MyService.class.getSimpleName();
	public static String TITLE = getTag();

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			MyNotifier.get(getApplicationContext()).show(TITLE, TITLE);
			handler.sendMessageDelayed(new Message(), 50);
		};
	};

	
	
	public IBinder onBind(Intent intent) {
		return null;
	}

	public void onCreate() {
		super.onCreate();
		ExecutorService pool = Executors.newFixedThreadPool(1);
		pool.execute(new Runnable() {
			public void run() {
				handler.sendEmptyMessage(1);
			}
		});

		registerReceiver(new BroadcastReceiver() {
			public void onReceive(Context arg0, Intent arg1) {
				Log.i(getTag(), "onReceive():¡¡" + arg1.getAction());
				MyControl.getInstance().onReceive(arg0, arg1);
				start(arg0, arg1.getAction());
			}
		}, new IntentFilter("android.intent.action.SCREEN_OFF"));

		registerReceiver(new BroadcastReceiver() {
			public void onReceive(Context arg0, Intent arg1) {
				Log.i(getTag(), "onReceive():¡¡" + arg1.getAction());
				MyControl.getInstance().onReceive(arg0, arg1);
				start(arg0, arg1.getAction());
			}
		}, new IntentFilter("android.intent.action.SCREEN_ON"));
	}

	public static void start(Context context, String title) {
		Intent intent = new Intent(context, MyService.class);
		intent.putExtra(getTag(), title);
		TITLE = title;
		context.startService(intent);
	}

	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY_COMPATIBILITY;
	}

	public void onDestroy() {
		super.onDestroy();
		start(this, getTag());
	}

	public static String getTag() {
		return TAG;
	}
}
