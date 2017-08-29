package com.exp.testtableview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/8/27.
 */

public class ActivityImage extends Activity {

    int[] images = new int[]{R.drawable.lijiang,R.drawable.qiao,R.drawable.shuangta,R.drawable.shui,R.drawable.xiangbi};

    int currentImage = 2;
    private int alpha =255;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);

        final Button plus = (Button) findViewById(R.id.increase);
        final Button minus = (Button) findViewById(R.id.decrease);

        final ImageView image1 =(ImageView) findViewById(R.id.image1);
        final ImageView image2 = (ImageView) findViewById(R.id.image2);
        final Button next = (Button) findViewById(R.id.next_image);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.setImageResource(images[++currentImage % images.length]);
            }
        });
        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if (v == plus){
                    alpha += 20;
                }else if (v == minus){
                    alpha -= 20;
                }else if (alpha >= 255){
                    alpha = 255;
                }else if (alpha <= 0){
                    alpha = 0;
                }
                image1.setImageAlpha(alpha);
            }
        };

        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);

        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                double scale = 1.0 * bitmap.getHeight() / image1.getHeight();
                int x = (int) (event.getX() * scale);
                int y = (int) (event.getY() * scale);
                if (x + 120 >bitmap.getWidth()){
                    x = bitmap.getWidth() - 120;
                }
                if (y + 120 >bitmap.getHeight()){
                    y = bitmap.getHeight() - 120;
                }
                image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                image2.setImageAlpha(alpha);
                return  false;

            }
        });

    }
}
