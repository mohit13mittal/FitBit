package com.example.android.fitbit;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by RMBLESSED on 13-09-2016.
 */
public class Bmicalc extends Activity {

    EditText e1,e2;
    TextView t1,t2,t3,t4,t5;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

// Get the references to the widgets
        final EditText e1 = (EditText) findViewById(R.id.et1);
        final EditText e2 = (EditText) findViewById(R.id.et2);
        final TextView t1 = (TextView) findViewById(R.id.tv);
        final TextView t2 = (TextView) findViewById(R.id.tv1);
        final TextView t3 = (TextView) findViewById(R.id.tv2);
        final TextView t4 = (TextView) findViewById(R.id.tv3);
        final TextView t5 = (TextView) findViewById(R.id.tv4);

        Button b= (Button) findViewById(R.id.ib1);
        b.setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be empty
            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }else {
                    if(Integer.parseInt(e1.getText().toString())<=3)
                        e1.setError("Please enter valid weight");
                }


                if(TextUtils.isEmpty(str2) ){

                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }else {
                    if(Integer.parseInt(e2.getText().toString())<=30)
                        e2.setError("Please enter valid height");
                }


//Get the user values from the widget reference
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;

//Calculate BMI value
                float bmiValue = calculateBMI(weight, height);

                SharedPreferences sp = getSharedPreferences("values", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putFloat("bmi",bmiValue);
                editor.apply();


//Define the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);
                t5.setText(String.valueOf("BMI: "+ bmiValue + " - " + bmiInterpretation));
                t5.requestFocus();

            }
        });
    }

    //Calculate BMI
    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}


