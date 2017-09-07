package com.exp.testtableview;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/4.
 */

public class ActivityContentResolver extends Activity {

    ContentResolver mContentResolver;
    Uri mUri = Uri.parse("content://com.exp.testtableview.FirstProvider/");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_resolver);
        mContentResolver = getContentResolver();
    }

    public void query(View source){
        Cursor cursor = mContentResolver.query(mUri,null,"query_where",null,null);
        Toast.makeText(this,"contentprovider return cursor is " + cursor,Toast.LENGTH_SHORT).show();
    }

    public void insert(View source){

        ContentValues values = new ContentValues();
        values.put("name","fkjava");
        Uri newUri = mContentResolver.insert(mUri,values);
        Toast.makeText(this,"contentprovider new content uri is " + newUri,Toast.LENGTH_SHORT).show();
    }

    public void update(View source){

        ContentValues values = new ContentValues();
        values.put("name","fkjava");
        int count = mContentResolver.update(mUri,values,"update_where",null);
        Toast.makeText(this,"contentprovider update count is " + count,Toast.LENGTH_SHORT).show();
    }

    public void delete(View source){

        int count = mContentResolver.delete(mUri,"delete_where",null);
        Toast.makeText(this,"contentprovider delete count is " + count,Toast.LENGTH_SHORT).show();
    }
}
