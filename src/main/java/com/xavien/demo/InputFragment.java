package com.xavien.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.xavien.utils.XLog;

/**
 * Created by Xavien on 15-4-3.
 */
public class InputFragment extends Fragment {

    private static final String TAG = "InputFragment";

    private Button mButton;
    private EditText mEditText;

    private onDisplayButtonClickListener mOnDisplayButtonClickListener;

    public InputFragment(){}

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
                mOnDisplayButtonClickListener.onDisplayButtonClick(mEditText.getText().toString());
            }
        });
        return view;
    }

    public interface onDisplayButtonClickListener{
        void onDisplayButtonClick(String input);
    }
}
