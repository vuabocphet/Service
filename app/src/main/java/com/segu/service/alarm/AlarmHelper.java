package com.segu.service.alarm;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmHelper {

    private static final String TAG = "Tinh-nv";

    private static final long DATE_TIME = 24 * 60 * 60 * 1000L;

    private static final long TIME =  0L;

    private static final int RQC_ALARM = 123;


    public static AlarmHelper get() {
        return new AlarmHelper();
    }

    public void init(Context context) {
        this.startAlarm(context,System.currentTimeMillis()+TIME);
    }

    public void restart(Context context) {
        this.startAlarm(context,System.currentTimeMillis()+TIME);
    }

    private void startAlarm(Context context, long time) {
        try {
            if (context == null) {
                log("start alarm error context null");
                return;
            }
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(context, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, RQC_ALARM, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            if (alarmManager == null) {
                log("start alarm error alarmManager null");
                return;
            }
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, time, pendingIntent);
            log("start alarm success");
        } catch (Exception e) {
            e.printStackTrace();
            log("start alarm error");
        }
    }

    private void cancelAlarm(Context context) {
        try {
            if (context == null) {
                log("cancel alarm error context null");
                return;
            }
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(context, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, RQC_ALARM, intent, 0);
            if (alarmManager == null) {
                log("cancel alarm error alarmManager null");
                return;
            }
            alarmManager.cancel(pendingIntent);
            log("cancel alarm success");
        } catch (Exception e) {
            e.printStackTrace();
            log("cancel alarm error");
        }
    }

    private void log(String message) {
        Log.i(TAG, message);
    }

}
