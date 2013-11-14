package com.example.test;

import com.example.test.r.MyReceiver;
import com.example.test.r.MyReceiver2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MyActivity2 extends Activity {
	private static final String TAG = MyActivity2.class.getSimpleName();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		MyService.start(this, getTag());
	}

	protected void onStart() {
		super.onStart();
		Log.i(getTag(), MyActivity2.getTag());
		Log.i(getTag(), MyNotifier.getTag());
		Log.i(getTag(), MyProvider.getTag());
		Log.i(getTag(), MyReceiver.getTag());
		Log.i(getTag(), MyReceiver2.getTag());
		Log.i(getTag(), MyService.getTag());
	}

	public static void show(Context context) {
		Intent activity = new Intent(context, MyActivity2.class);
		context.startActivity(activity);
	}

	public static String getTag() {
		return TAG;
	}
}
