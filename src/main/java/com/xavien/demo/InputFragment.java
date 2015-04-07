package com.xavien.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.xavien.utils.XLog;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Xavien on 15-4-3.
 */
public class InputFragment extends Fragment {

    private static final String TAG = "InputFragment";

    private Button mButton;
    private EditText mEditText;
    private Handler mHandler;

    private onDisplayButtonClickListener mOnDisplayButtonClickListener;

    public InputFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new MyHandler(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mOnDisplayButtonClickListener = (onDisplayButtonClickListener) activity;
        }catch (ClassCastException e){
            e.printStackTrace();
            XLog.e(TAG, "set listener failed.");
        }

        XLog.i(TAG, "set listener success.");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, null);
        mEditText = (EditText) view.findViewById(R.id.input_fragment_edittext);
        mButton = (Button) view.findViewById(R.id.input_fragment_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        insert2DataBase(mEditText.getText().toString());
                    }
                }).start();
            }
        });
        return view;
    }

    private synchronized void insert2DataBase(String title){
        DemoDbHelper demoDbHelper = new DemoDbHelper(getActivity());
        demoDbHelper.insert(title);
        mHandler.sendEmptyMessage(0);
    }

    class MyHandler extends Handler{
        private Reference<InputFragment> ref;

        public MyHandler(InputFragment inf){
            ref = new WeakReference<InputFragment>(inf);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    ref.get().mOnDisplayButtonClickListener.onDisplayButtonClick();
                    break;
                default:
                    break;
            }
        }
    }

    public interface onDisplayButtonClickListener{
        void onDisplayButtonClick();
    }
}
