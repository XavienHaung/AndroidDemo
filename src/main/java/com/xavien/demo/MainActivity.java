package com.xavien.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){
        switch (view.getId()){
            case R.id.btn_jumptoactionbardemo:
                startActivity(new Intent(this, ActionBarDemoActivity.class));
                break;
            case R.id.btn_jumptofragmentdemo:
                startActivity(new Intent(this, FragmentDemoActivity.class));
                break;
            default:
                break;
        }
    }
}
