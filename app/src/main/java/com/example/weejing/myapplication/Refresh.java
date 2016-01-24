package com.example.weejing.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by WeeJing on 24/1/16.
 */
public class Refresh extends Fragment {

    OkHttpClient client = new OkHttpClient();

    @Override
    public View onCreateView (LayoutInflater Inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = Inflater.inflate(R.layout.fragment_refresh,container, false);

        View.OnClickListener clicker = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.refresh:
                        refreshPage();

                        Fragment fragment = new result();
                        FragmentManager fragmentManagae = getFragmentManager();
                        fragmentManagae.beginTransaction().add(fragment,"hi").commit();
                }
            }
        };
        view .findViewById(R.id.refresh).setOnClickListener(clicker);
        return view;
    }

    public void refreshPage(){
        new AsyncTask<String, Integer,String >(){
            String response;
            @Override
            protected String doInBackground(String ... params){

                try{
                    response = run("https://nodejs-restful-tutorial.herokuapp.com/");
                }catch (IOException e){
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(String result){
                super.onPostExecute(result);
            }
        }.execute();
    }



    public String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
