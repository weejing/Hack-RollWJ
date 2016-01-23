package com.example.weejing.myapplication;

/**
 * Created by MSI-YJ on 1/23/2016.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private static final String TAG = CustomAdapter.class.getSimpleName();
    ArrayList<ItemObject> listArray;

    public CustomAdapter() {
        listArray = new ArrayList<ItemObject>(100);
//        listArray.add(new DataModel("name1", 5, 1.8, "Java"));
//        listArray.add(new DataModel("name2", 10, 2.8, "Python"));
//        listArray.add(new DataModel("name3", 15, 3.8, "Django"));
//        listArray.add(new DataModel("name4", 20, 4.8, "Groovy"));
//        listArray.add(new DataModel("name5", 25, 5.8, "Maven"));
    }

    @Override
    public int getCount() {
        return listArray.size();    // total number of elements in the list
    }

    @Override
    public Object getItem(int i) {
        return listArray.get(i);    // single item in the list
    }

    @Override
    public long getItemId(int i) {
        return i;                   // index number
    }

    public void addData(ItemObject input){
        listArray.add(input);
    }

    @Override
    public View getView(int index, View view, final ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.activity_text_view, parent, false);
        }

        final ItemObject dataModel = listArray.get(index);

        TextView textView = (TextView) view.findViewById(R.id.tv);
        textView.setText("haha");

        TextView textView2 = (TextView) view.findViewById(R.id.tv2);
        textView2.setText(dataModel.getCustomerName());

        TextView textView3 = (TextView) view.findViewById(R.id.tv3);
        textView3.setText(dataModel.getCustomerArrivalTime());

        TextView textView4 = (TextView) view.findViewById(R.id.tv4);
        textView4.setText(dataModel.getCustomerArray());

        Button button = (Button) view.findViewById(R.id.orderReceived);
        button.setText("" + dataModel.getCustomerName());


        // button click listener
        // this chunk of code will run, if user click the button
        // because, we set the click listener on the button only

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "string: " + dataModel.getCustomerId());
                Log.d(TAG, "int: " + dataModel.getCustomerName());
                Log.d(TAG, "double: " + dataModel.getCustomerArray());
                Log.d(TAG, "otherData: " + dataModel.getCustomerArrivalTime());

                Toast.makeText(parent.getContext(), "button clicked: " + dataModel.getCustomerArrivalTime(), Toast.LENGTH_SHORT).show();
            }
        });


        // if you commented out the above chunk of code and
        // activate this chunk of code
        // then if user click on any view inside the list view (except button)
        // this chunk of code will execute
        // because we set the click listener on the whole view



        return view;
    }
}