package com.mitchellkopcyzk.feederwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    private DatabaseManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_insert);
    }

    //Insert Entry
    public void insert(View v){
        EditText etType, etQty, etTimeOfDay, etDate, etWeather, etTempCelsius;
        String typeStr, qtyStr, TimeOfDayStr, dateStr, weatherStr, tempCelsiusStr;


        //Initialize TextValues from XML
        etType = findViewById(R.id.editTextType);
        etQty =  findViewById(R.id.editTextQty);
        etTimeOfDay = findViewById(R.id.editTextTimeOfDay);
        etDate = findViewById(R.id.editTextDate);
        etWeather = findViewById(R.id.editTextWeather);
        etTempCelsius = findViewById(R.id.editTextTempCelsius);

        //Get TextBox values and store into strings
        typeStr = etType.getText().toString();
        qtyStr = etQty.getText().toString();
        TimeOfDayStr = etTimeOfDay.getText().toString();
        dateStr = etDate.getText().toString();
        weatherStr = etWeather.getText().toString();
        tempCelsiusStr = etTempCelsius.getText().toString();

        try{
            int qtyInt = Integer.parseInt(qtyStr);
            double TempCelsiusInt = Double.parseDouble(tempCelsiusStr);
            Bird bird = new Bird(0,typeStr,qtyInt,TimeOfDayStr,dateStr,weatherStr,TempCelsiusInt);
            dbManager.insert(bird);
            Toast.makeText(this,"Bird Added", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(this,"Bird not added", Toast.LENGTH_LONG).show();
        }

        //Set The text boxes to empty
        etType.setText("");
        etQty.setText("");
        etTimeOfDay.setText("");
        etDate.setText("");
        etWeather.setText("");
        etTempCelsius.setText("");
    }

    public void goBack(View v){
        this.finish();
    }
}
