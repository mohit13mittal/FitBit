package com.example.android.fitbit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Homepage extends Activity {
    Button bt1,bt2,bt3,bt4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepageact);
        Button bt1 = (Button) findViewById(R.id.button2);
        Button bt2 = (Button) findViewById(R.id.button3);
        Button bt4 = (Button) findViewById(R.id.buttonh);
        Button bt3 = (Button) findViewById(R.id.button4);
        bt1.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View v) {

            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Bmrcalc.class);
                startActivity(intent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Bmicalc.class);
                startActivity(intent1);

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Fatcalc.class);
                startActivity(i);

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), History.class);
                startActivity(i);

            }
        });

    }}