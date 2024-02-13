package com.mitchellkopczyk.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/*
Mitchell Kopczyk
CSCI 322/522
Date Started and Completed: Sept 12 2018
 */

public class MainActivity extends AppCompatActivity {

    private ShipItem shipItem;
    private EditText weightET;
    private TextView baseTV, addedTV, totalTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shipItem = new ShipItem();
        weightET = findViewById(R.id.editTextWeight);
        baseTV = findViewById(R.id.textViewBase);
        addedTV = findViewById(R.id.textViewAdded);
        totalTV = findViewById(R.id.textViewTotal);
        weightET.addTextChangedListener(weightTextWatcher); //registering the listener
    } //end oncreate

    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                shipItem.setWeight((int) Double.parseDouble(s.toString()));
            }
            catch (NumberFormatException nfe){
                shipItem.setWeight(0);
            }
            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }; //end text watcher

    private void displayShipping() {
        baseTV.setText("$" + String.format("%.02f", shipItem.getBaseCost()));
        addedTV.setText("$" + String.format("%.02f", shipItem.getAddedCost()));
        totalTV.setText("$" + String.format("%.02f", shipItem.getTotalCost()));
    }
}
