package com.xavien.demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.xavien.utils.XLog;


public class ActionBarDemoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_demo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actionbardemo_actions, menu);
        return true;
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
