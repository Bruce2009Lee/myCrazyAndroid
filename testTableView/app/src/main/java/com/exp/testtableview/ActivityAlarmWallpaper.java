package com.exp.testtableview;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/5.
 */

public class ActivityAlarmWallpaper extends Activity {


    private Button startChange,stopChange;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_wallpaper_main);
        startChange = (Button) findViewById(R.id.start_change_wallpaper);
        stopChange = (Button) findViewById(R.id.stop_change_wallpaper);

        Intent intent = new Intent(ActivityAlarmWallpaper.this,ChangeWallpaperService.class);
        final PendingIntent pendingIntent = PendingIntent.getService(ActivityAlarmWallpaper.this,0,intent,0);
        startChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,0,60000,pendingIntent);
                startChange.setEnabled(false);
                stopChange.setEnabled(true);
                Toast.makeText(ActivityAlarmWallpaper.this,"壁纸定时更换成功啦",Toast.LENGTH_SHORT).show();
            }
        });
        stopChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startChange.setEnabled(true);
                stopChange.setEnabled(false);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);
            }
        });

    }
}
