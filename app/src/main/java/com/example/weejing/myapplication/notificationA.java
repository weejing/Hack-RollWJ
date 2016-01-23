package com.example.weejing.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class notificationA extends AppCompatActivity {
    ListView listView;
    CustomAdapter customAdapter;

    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customAdapter = new CustomAdapter();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button btn = (Button) findViewById(R.id.refresh);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new AsyncTask<String, Integer, String>() {
                    String response;

                    @Override
                    protected String doInBackground(String... params) {

                        try {
                                response = run("https://nodejs-restful-tutorial.herokuapp.com/order/update/JmCafe");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);
                        doThis(response);
                    }
                }.execute();
            }
        });

    }

    public void doThis(String result){
        String data = "";
        //TextView tv = (TextView) findViewById(R.id.tv);
        listView = (ListView) findViewById(R.id.listView);

        try {
            JSONArray jsonRootObject = new JSONArray(result);

            ItemObject item;
            for(int i=0; i < jsonRootObject.length(); i++){
                JSONObject jsonObject = jsonRootObject.getJSONObject(i);
                String id = jsonObject.optString("_id").toString();
                String custName = jsonObject.optString("custName").toString();
                float price = Float.parseFloat(jsonObject.optString("price").toString());
                String num = jsonObject.optString("num").toString();
                String arrivalTime = jsonObject.optString("arrival").toString();

                item = new ItemObject(id,custName,num,arrivalTime);

                customAdapter.addData(item);

                Toast.makeText(getBaseContext(),customAdapter.listArray.get(i).getCustomerName() ,
                        Toast.LENGTH_LONG).show();
    //            data += "Node"+i+" : \n id= "+ id +" \n Name= "+ custName +  " \n Price= "+ price +   " \n Number= "+ num +" \n " + " \n Arrival = " + arrivalTime;
            }
            listView.setAdapter(customAdapter);
    //        tv.setText(data);

        } catch (JSONException e) {e.printStackTrace();}

    }

}
