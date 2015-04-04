package com.xavien.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Codelary on 15-4-3.
 */
public class DemoFragment extends Fragment {

    private static final String TAG = "DemoFragment";

    private TextView mTextView;

    public DemoFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mTextView.setText(getArguments().getString("tips", "default tips"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, null);
        mTextView = (TextView) view.findViewById(R.id.demo_fragment_textview);

        return view;
    }
}
