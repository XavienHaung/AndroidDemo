package com.xavien.demo;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.xavien.utils.XLog;


public class ActionBarDemoActivity extends ActionBarActivity {

    private static final String TAG = "ActionBarDemoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_demo);
        XLog.i(TAG, "onCreate================");
    }

    @Override
    protected void onStart() {
        super.onStart();
        XLog.i(TAG, "onStart================");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        XLog.i(TAG, "onRestart================");
    }

    @Override
    protected void onResume() {
        super.onResume();
        XLog.i(TAG, "onResume================");
    }

    @Override
    protected void onPause() {
        super.onPause();
        XLog.i(TAG, "onPause================");
    }

    @Override
    protected void onStop() {
        super.onStop();
        XLog.i(TAG, "onStop================");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XLog.i(TAG, "onDestroy================");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        XLog.i(TAG, "onConfigurationChanged================");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        XLog.i(TAG, "onSaveInstanceState================");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        XLog.i(TAG, "onRestoreInstanceState================");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        XLog.i("Demo", "selected item id " + id);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            XLog.i("Demo", "selected menu settings");
            return true;
        } else if (id == R.id.action_search){
            XLog.i("Demo", "selected menu search");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
