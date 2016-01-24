package com.example.weejing.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

/**
 * Created by WeeJing on 24/1/16.
 */
public class Camera extends Activity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_xml);
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

                new CountDownTimer(4000, 1000) {

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {

                        redirect();
                    }
                }.start();
            }
        });
    }

    public void redirect ()
    {
        Intent intent = new Intent(this,JohnCena.class);
        startActivity(intent);

    }
}