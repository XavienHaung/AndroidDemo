package com.xavien.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Xavien on 2015/4/6.
 */
public class DisplayFragment extends Fragment {

    private TextView mTextView;

    public DisplayFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, null);
        mTextView = (TextView) view.findViewById(R.id.display_fragment_textview);
        return view;
    }

    public void display(String input){
        mTextView.setText(input);
    }
}
