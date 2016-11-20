package com.example.android.fitbit;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by RMBLESSED on 24-Sep-16.
 */
public class Fatcalc extends Activity{
    EditText e1,e2,e3;
    TextView t1,t2,t3,t4,t5,t6,t7;
    Button b;
    RadioButton r1,r2;

    double x=10.8+5.4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyfat);

        // Get the references to the widgets
        final EditText e1 = (EditText) findViewById(R.id.et7);
        final EditText e2 = (EditText) findViewById(R.id.et8);
        final EditText e3 = (EditText) findViewById(R.id.et9);
        final TextView t1 = (TextView) findViewById(R.id.tv11);
        final TextView t2 = (TextView) findViewById(R.id.tv12);
        final TextView t3 = (TextView) findViewById(R.id.tv13);
        final TextView t4 = (TextView) findViewById(R.id.tv14);
        final TextView t5 = (TextView) findViewById(R.id.tv15);
        final TextView t6 = (TextView) findViewById(R.id.tv16);
        final TextView t7 = (TextView) findViewById(R.id.tv17);
        final RadioButton r1 = (RadioButton) findViewById(R.id.radio3);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radio4);

        Button b= (Button) findViewById(R.id.ib3);
        b.setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be empty
            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();
                String str3 = e3.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }else {
                    if(Integer.parseInt(e1.getText().toString())<=3)
                        e1.setError("Please enter valid weight");
                }


                if(TextUtils.isEmpty(str2)){

                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }else {
                    if(Integer.parseInt(e2.getText().toString())<=30)
                        e2.setError("Please enter valid height");
                }


                if(TextUtils.isEmpty(str3)){

                    e3.setError("Please enter your age");
                    e3.requestFocus();
                    return;
                }

                //gett the user values from the widget reference
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;
                float age = Float.parseFloat(str3);

                if(r1.isChecked()== true)
                {x=10.8+5.4;}
                else if (r2.isChecked())
                {x=5.4;}

                //Calculate BFP value
                float bfpValue = calculateBFP(weight, height, age);

                SharedPreferences sp = getSharedPreferences("values", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putFloat("bfp",bfpValue);
                editor.apply();


                t7.setText(String.valueOf("Body Fat Percentage: "+ bfpValue +"%" ));
                t7.requestFocus();

            }
        });
    }

    //Calculate BFP
    private float calculateBFP (float weight, float height, float age) {
        return (float) ( (1.20*(weight / (height * height))+(0.23*age) - x ));
    }

}
