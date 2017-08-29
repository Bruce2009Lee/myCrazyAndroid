package com.exp.testtableview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/27.
 */

public class ActivitySimpleAdapter extends Activity {

    private String[] names= new String[]{
        "虎头","弄玉","李清照","李白"
    };

    private String[] descs = new String[]{
            "可爱的小孩","一个小女孩","一个文学女性","浪漫主义诗人"
    };

    private int[] imagesIds = new int[]{
            R.drawable.tiger,R.drawable.nongyu,R.drawable.qingzhao,R.drawable.libai
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleadapter);

        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0;  i < names.length ;i++){
            Map<String ,Object> listItem = new HashMap<String ,Object>();
            listItem.put("header",imagesIds[i]);
            listItem.put("personname",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"personname","header","desc"},new int[]{R.id.name,R.id.header,R.id.desc});
        ListView list = (ListView) findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),names[position]  + "is clicked",Toast.LENGTH_SHORT).show();
                System.out.println(names[position] + "被点击了");
            }
        });
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),names[position] + "is selected",Toast.LENGTH_SHORT).show();
                System.out.println(names[position] + "被选中了");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
