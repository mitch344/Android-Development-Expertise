package com.mitchellkopczyk.tapbuttoncounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Counter cnt; //model
    private TextView cntTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnt = new Counter();
        cntTV = findViewById(R.id.textViewCnt);
    }

    public void countTap(View v){
        cnt.addCnt(); //adds 1 to counter
        cntTV.setText(cnt.getCnter().toString()); //changes text to reflect the counter
    }
}
