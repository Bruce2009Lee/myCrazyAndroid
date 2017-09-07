package com.exp.testtableview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/9/2.
 */

public class ActivityActionData extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_data);

        Button button = (Button) findViewById(R.id.show_web_view);
        Button button2 = (Button) findViewById(R.id.edit_first_contact);
        Button button3 = (Button) findViewById(R.id.dial_phone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String data = "http://www.baidu.com";
                Uri uri = Uri.parse(data);


                intent.setData(uri);
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String data = "content://com.android.contacts/contacts/1";
                Uri uri = Uri.parse(data);


                intent.setData(uri);
                intent.setAction(Intent.ACTION_EDIT);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String data = "tel:15000158556";
                Uri uri = Uri.parse(data);


                intent.setData(uri);
                intent.setAction(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
    }
}
