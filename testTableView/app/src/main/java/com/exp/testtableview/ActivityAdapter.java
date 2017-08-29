package com.exp.testtableview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/8/27.
 */

public class ActivityAdapter extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        ListView listView1 = (ListView) findViewById(R.id.list1);
        String[] arr1 = {"孙悟空","牛魔王2","牛魔王"};
        ArrayAdapter<String > adapter1 = new ArrayAdapter<String>(this,R.layout.array_item,arr1);
        listView1.setAdapter(adapter1);

        ListView listView2 = (ListView) findViewById(R.id.list2);
        String[] arr2 = {"Java","Hibernate","Spring"};
        ArrayAdapter<String > adapter2 = new ArrayAdapter<String>(this,R.layout.check_item,arr2);
        listView2.setAdapter(adapter2);


    }
}

