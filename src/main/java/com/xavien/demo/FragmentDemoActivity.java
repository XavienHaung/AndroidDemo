package com.xavien.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class FragmentDemoActivity extends ActionBarActivity {

    private boolean fragment = true;

    private DemoFragment fragmentA;
    private Fragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        createFragments();
        getSupportFragmentManager().beginTransaction().add(R.id.demo_fragment_container, fragmentA).commit();
    }

    public void onFragmentsSwitch(View view){
        fragment = !fragment;
        switchFragments(fragment);
    }

    private void createFragments(){
        fragmentA = new DemoFragment();
        Bundle bundleA = new Bundle();
        bundleA.putString("tips", "Tips A");
        fragmentA.setArguments(bundleA);

        fragmentB = new DemoFragment();
        Bundle bundleB = new Bundle();
        bundleB.putString("tips", "Tips B");
        fragmentB.setArguments(bundleB);
    }

    private void switchFragments(boolean fragment){

        if(fragment){
            getSupportFragmentManager().beginTransaction().replace(R.id.demo_fragment_container, fragmentA).commit();
        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.demo_fragment_container, fragmentB).commit();
        }
    }

}
