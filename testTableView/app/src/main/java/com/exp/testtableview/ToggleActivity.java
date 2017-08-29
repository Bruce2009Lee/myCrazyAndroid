package com.exp.testtableview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

/**
 * Created by Administrator on 2017/8/27.
 */

public class ToggleActivity extends Activity {

    ToggleButton mToggleButton;
    Switch mSwitch;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_togglebutton);

        mToggleButton = (ToggleButton) findViewById(R.id.toggle);
        mSwitch = (Switch) findViewById(R.id.switcher);

        final LinearLayout test = (LinearLayout) findViewById(R.id.test);

        final CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    test.setOrientation(LinearLayout.HORIZONTAL);
                    mToggleButton.setChecked(true);
                    mSwitch.setChecked(true);
                }
                else {
                    test.setOrientation(LinearLayout.VERTICAL);
                    mToggleButton.setChecked(false);
                    mSwitch.setChecked(false);
                }
            }
        };
        mToggleButton.setOnCheckedChangeListener(listener);
        mSwitch.setOnCheckedChangeListener(listener);
    }
}
