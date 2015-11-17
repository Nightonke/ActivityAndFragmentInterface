package com.nightonke.activityandfragmentinterface;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements MyFragment.OnButtonClickListener {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.text_view);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
    }

    @Override
    public void OnButtonClick(int position) {
        text.setText("Click button " + position);
    }
}
