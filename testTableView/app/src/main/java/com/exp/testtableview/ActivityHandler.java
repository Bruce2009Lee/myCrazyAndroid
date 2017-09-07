package com.exp.testtableview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/8/31.
 */

public class ActivityHandler extends Activity {

    int[] imageIds = new int[]{
            R.drawable.java,R.drawable.javaee,R.drawable.ajax,R.drawable.android,R.drawable.swift};

    int currentImageId = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_handler);
        final ImageView imageView = (ImageView) findViewById(R.id.image_view);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123){
                    imageView.setImageResource(imageIds[currentImageId++ % imageIds.length]);
                }
            }
        };
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,100);
    }
}
