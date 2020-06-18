package com.segu.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.segu.service.notify.NotificationHelper;

public class ServiceAlwaysRunning extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationHelper notificationHelper = new NotificationHelper(this);
        Notification build = notificationHelper.getChannelNotification().build();
        startForeground(123, build);
        return START_NOT_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.e("Tinh-nv", "onTaskRemoved");
        super.onTaskRemoved(rootIntent);
    }
}
