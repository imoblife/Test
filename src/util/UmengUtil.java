package util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.umeng.analytics.MobclickAgent;

public class UmengUtil {
    private static final String TAG = UmengUtil.class.getSimpleName();
    private static final String appId = "557fb61967e58e5349003323";


    public static void checkUmeng(Context context, String activity) {
        if (TimeUtil.isUmengTimeUp(context)) {
            UmengUtil.trackActivity(context, activity);
        }
    }

    public static void trackActivity(Context context, String activity) {
        trackActivity(context, appId, activity);
        Log.i(TAG, "UC::trackActivityMB " + activity);
    }

    public static void trackActivity(Context context, String appId, String activity) {
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.onPageStart(activity);
        MobclickAgent.onResume(context, appId, null);
    }

//    public static void countUmeng(Context context, String action) {
//
//        String pageName = CountManager.instance(context).getPageName();
//        MobclickAgent.openActivityDurationTrack(false);
//        MobclickAgent.onPageStart(pageName);
//        MobclickAgent.onResume(context, CountManager.instance(context).getKey(), null);
//        AlarmManager am = (AlarmManager) context
//                .getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(action);
//        intent.putExtra("name", pageName);
//        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent,
//                PendingIntent.FLAG_CANCEL_CURRENT);
//        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 30000,
//                sender);
//    }
//
//    public static void endUmeng(Intent intent, Context context) {
//        String name = intent.getStringExtra("name");
//        MobclickAgent.onPageEnd(name);
//        MobclickAgent.onPause(context);
//    }
    
}
