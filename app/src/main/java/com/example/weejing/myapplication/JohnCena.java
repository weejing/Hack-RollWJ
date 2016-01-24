package com.example.weejing.myapplication;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.media.MediaPlayer.OnPreparedListener;

/**
 * Created by WeeJing on 24/1/16.
 */

import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class JohnCena extends Activity {

    private VideoView mVideoView;
    private MediaController mediaControls;
    private int position = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.john);
        mVideoView = (VideoView) findViewById(R.id.video_view);

        if (mediaControls == null) {

            mediaControls = new MediaController(JohnCena.this);

        }


        try{
            mVideoView.setMediaController(mediaControls);
            mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.johncenacut));

        }catch(Exception e){
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        mVideoView.requestFocus();

        mVideoView.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                mVideoView.seekTo(position);
                if (position == 0)
                {
                    mVideoView.start();
                } else{
                    mVideoView.pause();
                }
            }
            });
        }
    }
