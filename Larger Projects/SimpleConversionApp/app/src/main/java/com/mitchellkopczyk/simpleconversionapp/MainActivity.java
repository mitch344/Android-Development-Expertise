/*
Mitchell Kopczyk
CSCI 322-1
Start/Finish Date: 9/23/18
I decided to not use a model since the problem is fairly basic and
it would add extra complexities that are necessarily need.
 */
package com.mitchellkopczyk.simpleconversionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText furlongInput;
    private TextView milesOutput;

    private Double value;
    static final Double CONVERSIONFACTOR = 0.125;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialize();
    }

    public void Initialize(){
        //Get the components that I created in the xml
        furlongInput = findViewById(R.id.textInput);
        milesOutput = findViewById(R.id.textOutput);
    }

    //This is are onclick listener method
    public void ButtonClick(View v){
        //get the usr input and set it to are Double value
        value = Double.parseDouble(furlongInput.getText().toString());
        //multiply are value by the conversion factor
        value = value * CONVERSIONFACTOR;
        //output the answer to the usr
        DecimalFormat df = new DecimalFormat("#.00");
        milesOutput.setText("Number is " + df.format(value));
    }
}
