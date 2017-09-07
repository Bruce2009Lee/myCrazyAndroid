package com.exp.testtableview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/9/2.
 */

public class ActivityBunleForResult extends Activity {

    Button button;
    EditText city;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_for_resule);
        button = (Button) findViewById(R.id.bundle_bn);
        city = (EditText) findViewById(R.id.bundle_city);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityBunleForResult.this,ActivityBundleSelectCity.class);
            }
        });
    }


}
