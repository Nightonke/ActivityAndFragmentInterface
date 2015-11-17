package com.nightonke.activityandfragmentinterface;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 伟平 on 2015/11/17.
 */

public class MyFragment extends Fragment {

    private Activity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            activity = (Activity)context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);

        Button button = (Button) view.findViewById(R.id.button);
        button.setText(getArguments().getString("MESSAGE"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((OnButtonClickListener)activity)
                            .OnButtonClick(getArguments().getInt("POSITION"));
                } catch (ClassCastException cce){
                    cce.printStackTrace();
                }
            }
        });

        return view;
    }

    public interface OnButtonClickListener {
        void OnButtonClick(int position);
    }

    public static MyFragment newInstance(int position) {

        MyFragment f = new MyFragment();
        Bundle b = new Bundle();
        b.putInt("POSITION", position);
        b.putString("MESSAGE", "Button " + position);

        f.setArguments(b);

        return f;
    }

}
