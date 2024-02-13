package com.mitchellkopczyk.bmiandheartratecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //GUI Elements
    private Button TargetHeartRate, Clear, Calculate;
    private EditText Weight, Height;
    private Double dWeight, dHeight;
    private TextView TextViewBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TargetHeartRate = findViewById(R.id.buttonTargetHeartRate);
        TargetHeartRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenTargetHeartRate();
            }
        });

        Weight = findViewById(R.id.editTextWeight);
        Height = findViewById(R.id.editTextHeight);
        Clear = findViewById(R.id.buttonClear);
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Weight.setText("");
                Height.setText("");
                TextViewBMI.setText("BMI:");
            }
        });

        TextViewBMI = findViewById(R.id.textViewMessage);
        Calculate = findViewById(R.id.buttonCalculate);
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Weight.getText().toString().isEmpty() || Height.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Input Error",Toast.LENGTH_LONG).show();
                    return;
                }

                //Convert String to Double for calcualtions
                dWeight = Double.parseDouble(Weight.getText().toString());
                dHeight = Double.parseDouble(Height.getText().toString());

                if(dWeight > 999 || dWeight == 0 ){
                    Toast.makeText(getApplicationContext(),"Input Error",Toast.LENGTH_LONG).show();
                    return;
                }

                if(dHeight >999 || dHeight == 0){
                    Toast.makeText(getApplicationContext(),"Input Error",Toast.LENGTH_LONG).show();
                    return;
                }

                //Do Calculation
                Double BMI = dWeight /(dHeight * dHeight) *703.0;
                DecimalFormat df = new DecimalFormat("#.00");
                //Output the data and info to user
                if(BMI < 18.5){
                    TextViewBMI.setText("BMI: " + df.format(BMI) + " Underweight");
                }
                else if(BMI >= 18.5 && BMI <= 24.9){
                    TextViewBMI.setText("BMI: " + df.format(BMI) + " Normal");
                }
                else if(BMI >= 25 && BMI <= 29.9){
                    TextViewBMI.setText("BMI: " + df.format(BMI) + " Overweight");
                }
                else{
                    TextViewBMI.setText("BMI: " + df.format(BMI) + " Obese");
                }
            }
        });

    }

    //Start the Max Heart Rate Activity
    public void OpenTargetHeartRate(){
        Intent intent = new Intent(this,TargetHeartRate.class);
        startActivity(intent);
    }
}
