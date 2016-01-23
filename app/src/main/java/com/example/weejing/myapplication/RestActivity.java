package com.example.weejing.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by WeeJing on 23/1/16.
 */
public class RestActivity extends Activity {

    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.rest);
        Button click = (Button) findViewById(R.id.button1);

        click.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view){
                new AsyncTask<String, Integer,String >(){
                    String response;
                    @Override
                    protected String doInBackground(String ... params){

                        try{
                             response = run("https://nodejs-restful-tutorial.herokuapp.com/api/products");
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        return null;
                    }
                    @Override
                    protected void onPostExecute(String result){
                        super.onPostExecute(result);
                        Toast.makeText(RestActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                }.execute();
            }
        });
    }



}
