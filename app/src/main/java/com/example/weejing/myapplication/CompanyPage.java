package com.example.weejing.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CompanyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void goUpdate(View view)
    {
        Intent intent = new Intent(CompanyPage.this, updateMenuA.class);
        startActivity(intent);
    }
    public void goNotification(View view)
    {
        Intent intent = new Intent(CompanyPage.this, notificationA.class);
        startActivity(intent);
    }
    public void goCurrent(View view)
    {
        Intent intent = new Intent(CompanyPage.this, CurrentOrderA.class);
        startActivity(intent);
    }
    public void goSetting(View view)
    {
        Intent intent = new Intent(CompanyPage.this, settingA.class);
        startActivity(intent);
    }

}
