package com.exp.testtableview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by Administrator on 2017/9/2.
 */

public class ActivityBundleMain extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle);

        Button button = (Button) findViewById(R.id.user_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userName = (EditText) findViewById(R.id.user_name);
                EditText userPassword =(EditText) findViewById(R.id.user_password);
                RadioButton userGender = (RadioButton) findViewById(R.id.user_male);

                String gender = userGender.isChecked()?"man":"woman";
                Person person = new Person(userName.getText().toString(),userPassword.getText().toString(),gender);
                Bundle bundle = new Bundle();
                bundle.putSerializable("person",person);
                Intent intent = new Intent(ActivityBundleMain.this,ActivityBundleResult.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
