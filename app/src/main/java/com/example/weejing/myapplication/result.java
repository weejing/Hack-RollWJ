package com.example.weejing.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by WeeJing on 24/1/16.
 */
public class result extends Fragment {
    @Override
    public View onCreateView(LayoutInflater Inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = Inflater.inflate(R.layout.fragment_result, container, false);
        Toast.makeText(getActivity(),"text",Toast.LENGTH_SHORT).show();
        return view;
    }
}