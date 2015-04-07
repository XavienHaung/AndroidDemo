package com.xavien.demo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xavien.utils.XLog;

import java.util.List;

/**
 * Created by Xavien on 15-4-7.
 */
public class DemoAdapter extends BaseAdapter {
    private static final String TAG = "DemoAdapter";

    private Context mContext;
    private List<String> mDataList;

    public DemoAdapter(Context context, List<String> data){
        mContext = context;
        mDataList = data;
    }

    @Override
    public int getCount() {
        XLog.i(TAG, "data size " + mDataList.size());
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return position >= mDataList.size() ? "" : mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if(convertView != null){
            textView = (TextView)convertView.getTag();
        }else{
            textView = new TextView(mContext);
            textView.setTextSize(24);
            convertView = textView;
            convertView.setTag(textView);
        }

        textView.setText((String)getItem(position));

        return convertView;
    }

}
