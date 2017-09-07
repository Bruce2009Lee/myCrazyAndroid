package com.exp.testtableview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/2.
 */

public class ActivityDataSchemeHostPath extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("指定Scheme、Host、Path匹配的Activity");
        tv.setTextSize(30);
        setContentView(tv);
    }
}
