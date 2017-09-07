package com.exp.testtableview;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/9/3.
 */

public class ActivityAnimation extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        Button play =(Button) findViewById(R.id.animation_play);
        Button stop =(Button) findViewById(R.id.animation_stop);

        ImageView imageView = (ImageView) findViewById(R.id.animation);

        final AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();
            }
        });

    }
}
