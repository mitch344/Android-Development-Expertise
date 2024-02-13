package com.mitchellkopcyzk.rgb;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Text that will change color
    private  TextView txtColor;
    //Text boxes to for RGB
    private EditText txtRed, txtGreen, txtBlue;
    //Hold the values for are RGB components
    private int rComp = 0;
    private int bComp = 0;
    private int gComp = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Link the xml to code
        txtColor = findViewById(R.id.textColor);
        txtRed = findViewById(R.id.editTextRed);
        txtGreen = findViewById(R.id.editTextGreen);
        txtBlue = findViewById(R.id.editTextBlue);

        txtRed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //If the Text Changes
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txtRed.getText().toString().length() > 5){
                    return;
                }
                if(txtRed.getText().toString().compareTo("") == 0){
                    rComp = 0;
                    txtColor.setTextColor(Color.rgb(rComp,gComp,bComp));
                    return;
                }
                if(txtRed.getText().toString().charAt(0) == '-'){
                    if(txtRed.getText().length() == 1)
                        return;
                    txtColor.setTextColor(Color.rgb(0, gComp, bComp));
                    return;
                }
                if(txtRed.getText().toString().compareTo("") != 0) {
                    rComp = Integer.parseInt(txtRed.getText().toString());
                    if(rComp > 255){
                        //set the Red to 255
                        txtColor.setTextColor(Color.rgb(255, gComp, bComp));
                    }
                    else{
                        //Change color
                        txtColor.setTextColor(Color.rgb(rComp, gComp, bComp));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        txtGreen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txtGreen.getText().toString().length() > 5){
                    return;
                }
                //see if it's empty
                if(txtGreen.getText().toString().compareTo("") == 0){
                    gComp = 0;
                    txtColor.setTextColor(Color.rgb(rComp,gComp,bComp));
                    return;
                }
                if(txtGreen.getText().toString().charAt(0) == '-'){
                    if(txtGreen.getText().length() == 1)
                        return;
                    //set the green to zero
                    txtColor.setTextColor(Color.rgb(rComp, 0, bComp));
                    return;
                }
                if(txtGreen.getText().toString().compareTo("") != 0) {
                    gComp = Integer.parseInt(txtGreen.getText().toString());
                    if(gComp > 255){
                        //set the green comp to 255
                        txtColor.setTextColor(Color.rgb(rComp, 255, bComp));
                    }
                    else{
                        txtColor.setTextColor(Color.rgb(rComp, gComp, bComp));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtBlue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txtBlue.getText().toString().length() > 5){
                    return;
                }
                if(txtBlue.getText().toString().compareTo("") == 0){
                    bComp = 0;
                    txtColor.setTextColor(Color.rgb(rComp,gComp,bComp));
                    return;
                }
                if(txtBlue.getText().toString().charAt(0) == '-'){
                    if(txtBlue.getText().length() == 1)
                        return;
                    //set the blue comp to zero
                    txtColor.setTextColor(Color.rgb(rComp, gComp, 0));
                    return;
                }
                if(txtBlue.getText().toString().compareTo("") != 0) {
                    bComp = Integer.parseInt(txtBlue.getText().toString());
                    if(bComp > 255){
                        txtColor.setTextColor(Color.rgb(rComp, gComp, 255));
                    }
                    else{
                        txtColor.setTextColor(Color.rgb(rComp, gComp, bComp));
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
