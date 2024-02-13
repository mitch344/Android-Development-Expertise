package com.mitchellkopczyk.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button bntExclam;
    private TextView tvHello;
    private boolean isHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bntExclam = findViewById(R.id.buttonExclam);
        tvHello = findViewById(R.id.textViewHello);
        initializeGreeting();
        bntExclam.setOnClickListener(toggleGreeting);
    }
    private void initializeGreeting(){
        isHello = true;
    }
    private final View.OnClickListener toggleGreeting = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            if(isHello) //means hello is visible
            {
                isHello = false;
                tvHello.setText(R.string.goodbye);
            }
            else{
                isHello = true;
                tvHello.setText(R.string.hello);
            }
        }
    };
}
