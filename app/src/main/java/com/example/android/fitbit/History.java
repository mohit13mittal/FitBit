package com.example.android.fitbit;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class History extends AppCompatActivity {

    @BindView(R.id.textview1)
    TextView t1;
    @BindView(R.id.textview2)
    TextView t2;
    @BindView(R.id.textview3)
    TextView t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        SharedPreferences sp= getSharedPreferences("values", Context.MODE_PRIVATE);
        float bmr = sp.getFloat("bmr", -1);
        t1.setText(String.valueOf(bmr));
        float bmi = sp.getFloat("bmi", -1);
        t2.setText(String.valueOf(bmi));
        float bfp = sp.getFloat("bfp", -1);
        t3.setText(String.valueOf(bfp));


    }
}
