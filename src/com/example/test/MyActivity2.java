package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MyActivity2 extends Activity {
	private static final String TAG = MyActivity2.class.getSimpleName();
	private ImageView imageView1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageView1 = (ImageView) findViewById(R.id.imageView1);
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
		MyService.start(this, getTag());
	}

	public static void show(Context context) {
		Intent activity = new Intent(context, MyActivity2.class);
		context.startActivity(activity);
	}
	
	public static String getTag() {
		return TAG;
	}
}
