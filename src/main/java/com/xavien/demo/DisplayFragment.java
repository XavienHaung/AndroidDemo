package com.xavien.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xavien.utils.XLog;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xavien on 2015/4/6.
 */
public class DisplayFragment extends Fragment {
    private static final String TAG = "DisplayFragment";

    private ListView mListView;
    private BaseAdapter mListViewAdapter;
    private List<String> mDataList;
    private Handler mHandler;

    public DisplayFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataList = new ArrayList<String>();
        mHandler = new MyHandler(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, null);
        mListView = (ListView) view.findViewById(R.id.display_fragment_listview);
        mListViewAdapter = new DemoAdapter(getActivity(), mDataList);
        mListView.setAdapter(mListViewAdapter);
        return view;
    }

    private synchronized void refreshDataList(){
        mDataList.clear();
        DemoDbHelper demoDbHelper = new DemoDbHelper(getActivity());
        mDataList.addAll(demoDbHelper.queryAll());
        mHandler.sendEmptyMessage(0);
        XLog.i(TAG, "list size " + mDataList.size());
    }

    public void update(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                refreshDataList();
            }
        }).start();
    }

    static class MyHandler extends Handler{

        private Reference<DisplayFragment> ref;

        public MyHandler(DisplayFragment df){
            ref = new WeakReference<DisplayFragment>(df);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    ref.get().mListViewAdapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
    }
}
