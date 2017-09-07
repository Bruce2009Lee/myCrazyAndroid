package com.exp.testtableview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/6.
 */

public class ActivityMusicBoxMain extends Activity implements View.OnClickListener {

    TextView musicTitle, musicAuthor;

    ImageButton musicPlay, musicStop, musicLast, musicNext;

    ImageView background ;

    ActivityReceiver mActivityReceiver;

    public static final String CTL_ACTION = "com.exp.testtableview.CTL_ACTION";

    public static final String UPDATE_ACTION = "com.exp.testtableview.UPDATE_ACTION";

    int status = 0x11;

    String[] titleStrs = new String[] {"不完整的旋律","火力全开","脚本","就是现在","心中的日月","我们的歌"};
    String[] authorStrs = new String[] {"王力宏","王力宏","王力宏","王力宏","王力宏","王力宏"};
    int[] backImages = new int[] {R.drawable.wang1,R.drawable.wang2,R.drawable.wang3,R.drawable.wang4,R.drawable.wang5,R.drawable.wang6};



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("mainActivity","main1111");
        setContentView(R.layout.activity_musicbox_main);

        musicPlay = (ImageButton)findViewById(R.id.music_play);
        musicStop = (ImageButton)findViewById(R.id.music_stop);
        musicLast = (ImageButton)findViewById(R.id.music_last);
        musicNext = (ImageButton)findViewById(R.id.music_next);
        musicTitle = (TextView)findViewById(R.id.music_title);
        musicAuthor = (TextView)findViewById(R.id.music_author);
        background = (ImageView) findViewById(R.id.img_background);
        background.setImageResource(R.drawable.wang1);

        musicPlay.setOnClickListener(this);
        musicStop.setOnClickListener(this);
        musicLast.setOnClickListener(this);
        musicNext.setOnClickListener(this);

        mActivityReceiver = new ActivityReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UPDATE_ACTION);
        registerReceiver(mActivityReceiver,intentFilter);

        Intent intent = new Intent(this,MusicService.class);
        startService(intent);
        Log.d("mainActivity","startService");
    }

    //监听从musicservice返回的信息
    public class ActivityReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            int update = intent.getIntExtra("update",-1);
            int current = intent.getIntExtra("current",-1);
            if (current != -1){
                Toast.makeText(ActivityMusicBoxMain.this,Integer.toString(current),Toast.LENGTH_SHORT).show();
                Log.d("111",Integer.toString(current));
                musicTitle.setText(titleStrs[current]);
                musicAuthor.setText(authorStrs[current]);
                background.setImageResource(backImages[current]);

            }

            switch (update){
                case 0x11:
                    musicPlay.setImageResource(R.drawable.play);
                    status = 0x11;
                    break;
                case 0x12:
                    musicPlay.setImageResource(R.drawable.pause);
                    status = 0x12;
                    break;
                case 0x13:
                    musicPlay.setImageResource(R.drawable.play);
                    status = 0x13;
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent("com.exp.testtableview.CTL_ACTION");
        switch (v.getId()){
            case R.id.music_play:
                intent.putExtra("control",1);
                break;
            case R.id.music_stop:
                intent.putExtra("control",2);
                break;
            case R.id.music_last:
                intent.putExtra("control",3);
                break;
            case R.id.music_next:
                intent.putExtra("control",4);
                break;
        }
        sendBroadcast(intent);
    }
}
