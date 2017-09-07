package com.exp.testtableview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * Created by Administrator on 2017/9/4.
 */

public class ActivityGestureFliper extends Activity implements GestureDetector.OnGestureListener{

    ViewFlipper mFlipper;

    GestureDetector mGestureDetector;

    Animation[] mAnimations = new Animation[4];

    final int FLIP_DISTANCE = 50;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_fliper);

        mGestureDetector = new GestureDetector(this,this);
        mFlipper = (ViewFlipper) this.findViewById(R.id.gesture_fliper);
        mFlipper.addView(addImageView(R.drawable.java));
        mFlipper.addView(addImageView(R.drawable.javaee));
        mFlipper.addView(addImageView(R.drawable.ajax));
        mFlipper.addView(addImageView(R.drawable.android));
        mFlipper.addView(addImageView(R.drawable.swift));
        mFlipper.addView(addImageView(R.drawable.leaf));

        mAnimations[0] = AnimationUtils.loadAnimation(this,R.anim.left_in);
        mAnimations[1] = AnimationUtils.loadAnimation(this,R.anim.left_out);
        mAnimations[2] = AnimationUtils.loadAnimation(this,R.anim.right_in);
        mAnimations[3] = AnimationUtils.loadAnimation(this,R.anim.right_in);
    }

    private View addImageView(int resId){

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(resId);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        if (e1.getX() - e2.getX() > FLIP_DISTANCE){
            mFlipper.setInAnimation(mAnimations[0]);
            mFlipper.setOutAnimation(mAnimations[1]);
            mFlipper.showPrevious();
            return true;
        }else if (e2.getX() - e1.getX() > FLIP_DISTANCE){
            mFlipper.setInAnimation(mAnimations[2]);
            mFlipper.setOutAnimation(mAnimations[3]);
            mFlipper.showNext();
            return true;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
}
