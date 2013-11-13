package com.example.test.c;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.test.m.MyModel;

public class MyControl {

	private static final String TAG = MyControl.class.getSimpleName();

	private static MyControl instance;

	private MyListener listener;

	private MyControl() {
		// TODO Auto-generated constructor stub
	}

	public static MyControl getInstance() {
		if (instance == null) {
			return instance = new MyControl();
		} else {
			return instance;
		}
	}

	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "onReceive()22: " + intent.getAction());
		MyModel.add(intent.getAction());

		if (listener != null) {
			listener.receive(MyModel.get());
		}
	}

	public MyListener getListener() {
		return listener;
	}

	public void setListener(MyListener listener) {
		this.listener = listener;
	}

}
