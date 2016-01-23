package com.example.weejing.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by MSI-YJ on 1/24/2016.
 */
 class listview extends ArrayAdapter<String> {

    listview(Context context,String [] foods ){
        super(context, R.layout.custom_row,foods);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater buckyInflater = LayoutInflater.from(getContext());
        View customView = buckyInflater.inflate(R.layout.custom_row,parent,false);

    }
}

