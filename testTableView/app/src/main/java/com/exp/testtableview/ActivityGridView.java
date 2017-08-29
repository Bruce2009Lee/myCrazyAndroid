package com.exp.testtableview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/28.
 */

public class ActivityGridView extends Activity {

    GridView mGridView;

    ImageView mImageView;

    int[] imageIds = new int[]{R.drawable.bomb5,R.drawable.bomb6,R.drawable.bomb7,
            R.drawable.bomb8,R.drawable.bomb9,R.drawable.bomb10,
            R.drawable.bomb11,R.drawable.bomb12,R.drawable.bomb13,R.drawable.bomb14,R.drawable.bomb15};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        List<Map<String ,Object>> listItems = new ArrayList<Map<String ,Object>>();
        for (int i = 0;  i<imageIds.length ; i++){

            Map<String ,Object> listItem = new HashMap<String ,Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        mImageView = (ImageView) findViewById(R.id.imageview);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.activity_cell,new String[]{"image"},new int[]{R.id.grid_image1});
        mGridView = (GridView) findViewById(R.id.grid01);
        mGridView.setAdapter(simpleAdapter);

        mGridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mImageView.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mImageView.setImageResource(imageIds[position]);
            }
        });

    }
}

