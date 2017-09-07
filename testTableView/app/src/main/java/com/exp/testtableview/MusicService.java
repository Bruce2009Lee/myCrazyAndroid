package com.exp.testtableview;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/9/6.
 */

public class MusicService extends Service {


    MyReceiver serviceReceiver;
    AssetManager mManager;

    String[] musics = new String []{"不完整的旋律.mp3","火力全开.mp3","脚本.mp3","就是现在.mp3","心中的日月.mp3","我们的歌.mp3"};

    MediaPlayer mPlayer;

    int status = 0x11;

    int current = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("mainActivity","MusicService start");
        mManager = getAssets();
        serviceReceiver = new MyReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ActivityMusicBoxMain.CTL_ACTION);
        registerReceiver(serviceReceiver,intentFilter);

        mPlayer = new MediaPlayer();
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                current++;
                if (current >= 6 ){
                    current = 0;
                }
                Intent sendIntent = new Intent(ActivityMusicBoxMain.UPDATE_ACTION);
                sendIntent.putExtra("current",current);
                sendBroadcast(sendIntent);
                prepareAndPlay(musics[current]);

            }
        });
    }

    public void prepareAndPlay(String music){
        try{
            Log.d("mainActivity"," start Music ");
            AssetFileDescriptor afd = mManager.openFd(music);
            mPlayer.reset();
            mPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mPlayer.prepare();
            mPlayer.start();
            Log.d("mainActivity"," end Music ");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            int control = intent.getIntExtra("control",-1);
            switch (control){
                case 1:
                    if (status == 0x11){
                        prepareAndPlay(musics[current]);
                        status = 0x12;

                    }else if (status == 0x12){
                        mPlayer.pause();
                        status = 0x13;
                    }else if (status == 0x13){
                        mPlayer.start();
                        status = 0x12;
                    }
                    break;
                case 2:
                    if (status == 0x12 || status == 0x13){
                        mPlayer.stop();
                        status = 0x11;
                    }
                    break;
                case 4://next
                    mPlayer.stop();
                    if ( current == musics.length -1 ) {
                        current = 0;
                        prepareAndPlay(musics[0]);
                    }else{
                        prepareAndPlay(musics[++current]);
                    }

//                    }else {
//                        prepareAndPlay(musics[0]);
//                    }
                    status = 0x12;
                    break;
                case 3://last
                    mPlayer.stop();
                    if (current <= 0){
                        prepareAndPlay(musics[musics.length - 1]);
                        current = musics.length - 1;
                    }else {
                        prepareAndPlay(musics[--current]);
                    }
                    status = 0x12;
                    break;
            }
            Intent sendIntent = new Intent(ActivityMusicBoxMain.UPDATE_ACTION);
            sendIntent.putExtra("update",status);
            sendIntent.putExtra("current",current);
            sendBroadcast(sendIntent);
        }


    }
}
