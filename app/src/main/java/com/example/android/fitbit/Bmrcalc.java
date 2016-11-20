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
 * Created by RMBLESSED on 17-Sep-16.
 */

public class Bmrcalc extends Activity {
    EditText e1,e2,e3;
    TextView t1,t2,t3,t4,t5,t6,t7;
    Button b1;
    RadioButton r1,r2;

    double a=5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);

        // Get the references to the widgets
        final EditText e1 = (EditText) findViewById(R.id.et4);
        final EditText e2 = (EditText) findViewById(R.id.et5);
        final EditText e3 = (EditText) findViewById(R.id.et6);
        final TextView t1 = (TextView) findViewById(R.id.tv5);
        final TextView t2 = (TextView) findViewById(R.id.tv6);
        final TextView t3 = (TextView) findViewById(R.id.tv8);
        final TextView t4 = (TextView) findViewById(R.id.tv9);
        final TextView t5 = (TextView) findViewById(R.id.tv10);
        final TextView t6 = (TextView) findViewById(R.id.tv11);
        final TextView t7=(TextView) findViewById(R.id.tv18);
        final RadioButton r1 = (RadioButton) findViewById(R.id.radio1);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radio2);


        Button b1= (Button) findViewById(R.id.ib2);
        b1.setOnClickListener(new View.OnClickListener() {

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
                float height = Float.parseFloat(str2);
                float age = Float.parseFloat(str3);

//Calculate BMR value
                float bmrValue = calculateBMR(weight, height, age);

                SharedPreferences sp = getSharedPreferences("values", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putFloat("bmr",bmrValue);
                editor.apply();


                        t6.setText(String.valueOf("BMR: "+bmrValue + " Calories/Day"));
                t6.requestFocus();




                if(r1.isChecked()== true)
                {a=5;}
                else if (r2.isChecked())
                {a=161;}

            }
        });
    }




    //Calculate BMR
    private float calculateBMR (float weight, float height, float age) {
        return (float) ( (10 * (weight)) + (6.25 * (height)) - (5 * age) - (a)) ;
    }


}
