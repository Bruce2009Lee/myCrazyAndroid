package com.exp.testtableview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

/**
 * Created by Administrator on 2017/8/27.
 */

public class CalculatorActivity extends Activity {

    GridLayout mGridLayout;

    String[] chars = new String []{ "7","8","9","/",
                                    "4","5","6","*",
                                    "1","2","3","+",
                                    ".","0","=","-",};


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gridlayout);
        for (int i = 0 ; i < chars.length ; i++){

            Button button = new Button(this);
            button.setText(chars[i]);
            button.setTextSize(40);
            button.setPadding(5,35,5,35);
            GridLayout.Spec rowSpec = GridLayout.spec( i/4 + 2);
            GridLayout.Spec columnSpec = GridLayout.spec( i%4 );
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
            params.setGravity(Gravity.FILL);
            mGridLayout.addView(button,params);
        }
    }
}
