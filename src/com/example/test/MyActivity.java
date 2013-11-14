package com.example.test;

import com.example.test.c.MyControl;
import com.example.test.c.MyListener;
import com.example.test.m.MyModel;
import com.example.test.r.MyReceiver;
import com.example.test.r.MyReceiver2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MyActivity extends Activity implements MyListener {
	private static final String TAG = MyActivity.class.getSimpleName();
	private TextView tv;

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			tv.setText((String) msg.obj);
		};
	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.tv);
		tv.setText(MyModel.get());
	}

	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		MyService.start(this, getTag());
		// MyActivity2.show(this);

		MyControl.getInstance().setListener(this);
	}

	protected void onStart() {
		super.onStart();
		Log.i(getTag(), MyActivity.getTag());
		Log.i(getTag(), MyNotifier.getTag());
		Log.i(getTag(), MyProvider.getTag());
		Log.i(getTag(), MyReceiver.getTag());
		Log.i(getTag(), MyReceiver2.getTag());
		Log.i(getTag(), MyService.getTag());
	}

	public static void show(Context context) {
		Intent activity = new Intent(context, MyActivity.class);
		context.startActivity(activity);
	}

	public static String getTag() {
		return TAG;
	}

	public void receive(String model) {
		Message msg = handler.obtainMessage();
		msg.obj = model;
		handler.sendMessage(msg);
	}
}
