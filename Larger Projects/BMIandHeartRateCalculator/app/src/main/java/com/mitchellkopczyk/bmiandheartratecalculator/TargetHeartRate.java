package com.mitchellkopczyk.bmiandheartratecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*This is the max heart rate activity it triggered from the main activity*/

public class TargetHeartRate extends AppCompatActivity {

    //GUI Elements for the Max Heart Rate Activity
    private Button BackButton, CalculateButton;
    private EditText AgeEditText;
    private Integer age, MaxHeartRate;
    private TextView MHRTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_heart_rate);
        AgeEditText = findViewById(R.id.editTextAge);
        MHRTextView = findViewById(R.id.textViewMaxHeart);
        CalculateButton = findViewById(R.id.buttonCalculateMax);
        CalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validate Data
                if(AgeEditText.getText().toString().length() > 3){
                    Toast.makeText(getApplicationContext(),"Input Error",Toast.LENGTH_LONG).show();
                    return;
                }
                if(AgeEditText.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Input Error",Toast.LENGTH_LONG).show();
                    return;
                }
                age = Integer.parseInt(AgeEditText.getText().toString());
                if(age >= 1 && age <150){
                    MaxHeartRate = 220 - age; //Calcualtion
                    MHRTextView.setText("Your Max Heart Rate: " + MaxHeartRate.toString());
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Age",Toast.LENGTH_LONG).show();
                }
            }
        });

        BackButton = findViewById(R.id.buttonBack);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //end activity
            }
        });
    }
}
