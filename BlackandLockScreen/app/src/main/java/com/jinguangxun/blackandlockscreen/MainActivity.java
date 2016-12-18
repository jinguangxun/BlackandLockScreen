package com.jinguangxun.blackandlockscreen;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(MainActivity.this)) {
            } else {
                Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:com.jinguangxun.blackandlockscreen"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

            int OVERLAY_PERMISSION_REQ_CODE = 8888;

            if (!Settings.canDrawOverlays(MainActivity.this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }
        }

        createNotification();

        finish();
        System.exit(0);
    }

    public void createNotification(){
        Intent intentStart = new Intent(this, Start.class);
        PendingIntent actionStart = PendingIntent.getBroadcast(this, 0, intentStart, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intentStop = new Intent(this, Stop.class);
        PendingIntent actionStop = PendingIntent.getBroadcast(this, 1, intentStop, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intentClose = new Intent(this, Close.class);
        PendingIntent actionClose = PendingIntent.getBroadcast(this, 2, intentClose, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Black & Lock Screen");
        builder.setSmallIcon(R.drawable.ic_stat_name);
        builder.setOngoing(true);
        builder.addAction(R.drawable.ic_start, "Start",actionStart);
        builder.addAction(R.drawable.ic_stop, "Stop",actionStop);
        builder.addAction(R.drawable.ic_close, "Close",actionClose);

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(1,notification);
    }

}
