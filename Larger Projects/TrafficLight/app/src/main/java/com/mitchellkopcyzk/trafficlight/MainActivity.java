package com.mitchellkopcyzk.trafficlight;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //User Interface Elements
    private Button buttonColor;
    private TextView textViewColor;
    private View viewColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set Controls via findViewID
        viewColor = findViewById(R.id.viewColor);
        buttonColor = findViewById(R.id.buttonColor);
        textViewColor = findViewById(R.id.textViewColor);
        textViewColor.setText("Red");
        viewColor.setBackgroundColor(Color.RED);
        //Button Click Handler
        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check to See if the light is Red if so Change to Green
                if(textViewColor.getText().toString().compareTo("Red") == 0){
                    textViewColor.setText("Green");
                    viewColor.setBackgroundColor(Color.GREEN);
                }
                //Check to see if the light is Green if so change to Yellow
                else if(textViewColor.getText().toString().compareTo("Green") == 0){
                    textViewColor.setText("Yellow");
                    viewColor.setBackgroundColor(Color.YELLOW);
                }
                //Check to see if the light if it yellow change to Red
                else{
                    textViewColor.setText("Red");
                    viewColor.setBackgroundColor(Color.RED);
                }
            }
        });
    }
}
