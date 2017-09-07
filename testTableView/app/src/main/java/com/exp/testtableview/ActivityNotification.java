package com.exp.testtableview;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/30.
 */

public class ActivityNotification extends Activity {

    static final int NOTIFICATION_ID = 0x123;

    NotificationManager mNotificationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_main);

        Button button = (Button) findViewById(R.id.change_orientation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration configuration = getResources().getConfiguration();
                if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                    ActivityNotification.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }

                if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                    ActivityNotification.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        });

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE?"横向屏幕":"纵向屏幕";
        Toast.makeText(this,"system screen changed:" + screen,Toast.LENGTH_SHORT).show();
    }

    public void send(View source){

        Intent intent = new Intent(ActivityNotification.this,ActivityOtherActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(ActivityNotification.this,0,intent,0);
        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("有新消息")
                .setSmallIcon(R.drawable.notify)
                .setContentTitle("one new message")
                .setContentText("congratulation")
                .setDefaults(Notification.DEFAULT_SOUND)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .build();
        mNotificationManager.notify(NOTIFICATION_ID,notification);
    }

    public void del(View source){
        mNotificationManager.cancel(NOTIFICATION_ID);
    }
}
