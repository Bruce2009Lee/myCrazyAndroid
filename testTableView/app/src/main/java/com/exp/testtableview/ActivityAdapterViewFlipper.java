package com.exp.testtableview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/8/29.
 */

public class ActivityAdapterViewFlipper extends Activity {

    int[] imageIds = new int[]{R.drawable.shuangzi,R.drawable.shuangta,R.drawable.chunv,R.drawable.tianxie,R.drawable.sheshou,R.drawable.juxie,
            R.drawable.shuiping,R.drawable.shizi,R.drawable.baiyang,R.drawable.jinniu,R.drawable.mojie};

    private AdapterViewFlipper mFlipper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapterviewfliper);

        mFlipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(ActivityAdapterViewFlipper.this);
                imageView.setImageResource(imageIds[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;

            }
        };
        mFlipper.setAdapter(adapter);
    }

    public void prev(View source){

        mFlipper.showPrevious();
        mFlipper.stopFlipping();
    }

    public void next(View source){

        mFlipper.showNext();
        mFlipper.stopFlipping();
    }

    public void auto(View source){

        mFlipper.startFlipping();
    }
}
