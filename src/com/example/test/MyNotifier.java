package com.example.test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyNotifier {

	private static final String TAG = MyNotifier.class.getSimpleName();
	private static MyNotifier instance;
	private Context context;
	private int index;
	private int[] icons;
	public static int iconId;

	private MyNotifier(Context context) {
		this.context = context;
		this.icons = new int[4];
		this.icons[0] = R.drawable.spinner_0;
		this.icons[1] = R.drawable.spinner_90;
		this.icons[2] = R.drawable.spinner_180;
		this.icons[3] = R.drawable.spinner_270;
	}

	public static MyNotifier get(Context context) {
		if (instance == null) {
			return instance = new MyNotifier(context);
		} else {
			return instance;
		}
	}

	public void show(String title, String text) {
		iconId = icons[index++ % 4];

		NotificationManager nm = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification nf = new Notification(iconId, title,
				System.currentTimeMillis());
		nf.flags = Notification.FLAG_AUTO_CANCEL;
		Intent intent = new Intent(context, MyActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
				intent, 0);
		nf.setLatestEventInfo(context, title, text, contentIntent);
		nm.notify(1, nf);
	}

	public static String getTag() {
		return TAG;
	}
}
