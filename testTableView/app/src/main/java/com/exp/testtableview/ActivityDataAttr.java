package com.exp.testtableview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/9/2.
 */

public class ActivityDataAttr extends Activity implements View.OnClickListener{

    private Button schemeButton;
    private Button schemeHostPathButton;
    private Button schemeHostPortButton;
    private Button schemeHostPathPortButton;
    private Button schemeHostPathPortTypeButton;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_attr_main);


        schemeButton = (Button) findViewById(R.id.scheme);
        schemeHostPathButton = (Button) findViewById(R.id.scheme_host_path);
        schemeHostPortButton = (Button) findViewById(R.id.scheme_host_port);
        schemeHostPathPortButton = (Button) findViewById(R.id.scheme_host_path_port);
        schemeHostPathPortTypeButton = (Button) findViewById(R.id.scheme_host_path_port_type);


        schemeButton.setOnClickListener(this);
        schemeHostPathButton.setOnClickListener(this);
        schemeHostPortButton.setOnClickListener(this);
        schemeHostPathPortButton.setOnClickListener(this);
        schemeHostPathPortTypeButton.setOnClickListener(this);

    }

    public void scheme(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.crazyit.org:1234/test"));
        startActivity(intent);
    }
    public void schemeHostPort(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
        startActivity(intent);
    }
    public void schemeHostPath(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:1234/mypath"));
        startActivity(intent);
    }
    public void schemeHostPortPath(View source)
    {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/mypath"));
        startActivity(intent);
    }
    public void schemeHostPortPathType(View source)
    {
        Intent intent = new Intent();
        // 同时设置Intent的Data、Type属性
        intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/mypath"), "abc/xyz");
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scheme:
                scheme(v);
                break;
            case R.id.scheme_host_path:
                schemeHostPath(v);
                break;
            case R.id.scheme_host_path_port:
                schemeHostPortPath(v);
                break;
            case R.id.scheme_host_path_port_type:
                schemeHostPortPathType(v);
                break;
            case R.id.scheme_host_port:
                schemeHostPort(v);
                break;
            default:
                break;
        }
    }
}
