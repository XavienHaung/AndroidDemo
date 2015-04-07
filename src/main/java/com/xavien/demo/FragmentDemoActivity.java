package com.xavien.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class FragmentDemoActivity extends ActionBarActivity implements InputFragment.onDisplayButtonClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
    }

    @NonNull
    @Override
    public void onDisplayButtonClick() {
        DisplayFragment fragment = (DisplayFragment)getSupportFragmentManager().findFragmentById(R.id.display_fragment);
        fragment.update();
    }
}
