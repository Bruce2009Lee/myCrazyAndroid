package com.exp.testtableview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/2.
 */

public class ActivityBundleResult extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_result);

        TextView userName =(TextView) findViewById(R.id.show_user_name);
        TextView userPassword = (TextView) findViewById(R.id.show_user_paswd);
        TextView userGender = (TextView) findViewById(R.id.show_user_gender);

        Intent intent = getIntent();
        Person person =(Person) intent.getSerializableExtra("person");
        userName.setText("您的用户名：" + person.getName());
        userPassword.setText("您的密码为：" + person.getPasswd());
        userGender.setText("您的性别为：" + person.getGender());
    }
}
