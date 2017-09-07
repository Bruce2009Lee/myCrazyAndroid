package com.exp.testtableview;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/9/5.
 */

public class ChangeWallpaperService extends Service {


    int[] wallpapers = new int[]{
            R.drawable.shuangta,R.drawable.lijiang,R.drawable.baiyang
    };

    WallpaperManager mManager;
    int current = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("ChangeWallpaper111","change");
        if (current >= 3){
            current = 0;
        }
        try {
            mManager.setResource(wallpapers[current++]);
        }catch (Exception e){
            e.printStackTrace();
        }
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mManager = WallpaperManager.getInstance(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
