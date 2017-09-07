package com.exp.testtableview;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/8/31.
 */

public class ActivityAsyncTask extends Activity {

    private TextView mTextView;

    private Button downLoadApk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        mTextView = (TextView) findViewById(R.id.async_text_show);
        downLoadApk = (Button) findViewById(R.id.start_download);

        downLoadApk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DownTask downTask = new DownTask(ActivityAsyncTask.this);
                    downTask.execute(new URL("https://www.chinaums.com/app/ttf/ttf.apk"));
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
            }
        });
    }

//    public void download(View source) throws MalformedURLException {
//        DownTask downTask = new DownTask(this);
//        downTask.execute(new URL("https://www.chinaums.com/app/ttf/ttf.apk"));
//
//    }

    class DownTask extends AsyncTask<URL,Integer,String >{

        ProgressDialog mProgressDialog ;
        int hasRead = 0;
        Context mContext;

        public DownTask(Context context) {
            mContext = context;
        }

        @Override
        protected String doInBackground(URL... params) {
            StringBuilder stringBuilder = new StringBuilder();

            try{

//                URLConnection connection = params[0].openConnection();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
//                String line = null;
//
//
//                while ((line = bufferedReader.readLine()) != null){
//                    stringBuilder.append(line + "\n");
//                    hasRead++;
//                    publishProgress(hasRead);
//                }
//                return stringBuilder.toString();

                URLConnection connection = params[0].openConnection();
                connection.connect();
                //这将是有用的，这样你可以显示一个典型的0-100%的进度条
                int fileLength = connection.getContentLength();

                InputStream input = new BufferedInputStream(params[0].openStream());
                OutputStream output = new FileOutputStream("/sdcard/myapk.apk");

                byte data[] = new byte[1024];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);
                }

                output.flush();
                output.close();
                input.close();

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            mTextView.setText(s);
            mProgressDialog.dismiss();
        }

        @Override
        protected void onPreExecute() {
            mProgressDialog = new ProgressDialog(ActivityAsyncTask.this);
            mProgressDialog.setTitle("任务执行中");
            mProgressDialog.setMessage("任务正在执行，请稍等");
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mTextView.setText("已经读取了[" + values[0] + "]行");
            mProgressDialog.setProgress(values[0]);
        }
    }
}
