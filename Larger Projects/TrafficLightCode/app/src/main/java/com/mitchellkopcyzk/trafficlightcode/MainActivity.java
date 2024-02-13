package com.mitchellkopcyzk.trafficlightcode;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        buildGUI();

    }

    private void buildGUI(){

        //Reltive layout parameters
        RelativeLayout.LayoutParams layParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layParams);


        //View
        RelativeLayout.LayoutParams viewParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        viewParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        viewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        //Create View
        final View view = new View(this);
        view.setLayoutParams(viewParams);
        relativeLayout.addView(view);
        view.setBackgroundColor(Color.RED);


        //TextView
        RelativeLayout.LayoutParams textViewParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        textViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        textViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        //Create TextView
        final TextView viewColor = new TextView(this);
        viewColor.setText("Red");
        viewColor.setLayoutParams(textViewParams);
        relativeLayout.addView(viewColor);


        //Button
        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        //Create Button
        Button button = new Button(this);
        button.setText("Change");
        button.setLayoutParams(buttonParams);

        //set up button handler
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check to See if the light is Red if so Change to Green
                if(viewColor.getText().toString().compareTo("Red") == 0){
                    viewColor.setText("Green");
                    view.setBackgroundColor(Color.GREEN);
                }
                //Check to see if the light is Green if so change to Yellow
                else if(viewColor.getText().toString().compareTo("Green") == 0){
                    viewColor.setText("Yellow");
                    view.setBackgroundColor(Color.YELLOW);
                }
                //Check to see if the light if it yellow change to Red
                else{
                    viewColor.setText("Red");
                    view.setBackgroundColor(Color.RED);
                }
            }
        });
        relativeLayout.addView(button);


        setContentView(relativeLayout);

    }
}
