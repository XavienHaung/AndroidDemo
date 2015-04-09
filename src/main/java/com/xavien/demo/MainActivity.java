package com.xavien.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.xavien.utils.XLog;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        XLog.i(TAG, "requestCode:" + requestCode + ", resultCode:" + resultCode);
    }

    private void launchOtherApps(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Message to send");
        intent.setType("text/plain");
        Intent chooser = Intent.createChooser(intent, "Send message via");
        startActivity(chooser);
    }

    private void startActionBarActivity(){
        Intent intent = new Intent(this, ActionBarDemoActivity.class);
//        startActivity(intent);
        startActivityForResult(intent, 1, null);
    }

    public void onButtonClick(View view){
        switch (view.getId()){
            case R.id.btn_jumptoactionbardemo:
                startActionBarActivity();
                break;
            case R.id.btn_jumptofragmentdemo:
                startActivity(new Intent(this, FragmentDemoActivity.class));
                break;
            case R.id.btn_launcherapps:
                launchOtherApps();
                break;
            default:
                break;
        }
    }
}
