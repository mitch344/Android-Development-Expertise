package com.mitchellkopczyk.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView numberDisplayTV;
    private SimpleExpression expression;
    private static final String TAG = "Calc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expression = new SimpleExpression();
        numberDisplayTV = findViewById(R.id.textViewAnswer);
    }

    public void goAC(View v){
        expression.clearOperands();
        numberDisplayTV.setText("0");
    }

    public void goOperand(View v){
        String val = (String)numberDisplayTV.getText();
        String digit = (String)v.getContentDescription();
        if (val.charAt(0) == '0')
            numberDisplayTV.setText(digit);
        else{
            numberDisplayTV.setText((String)numberDisplayTV.getText() + digit.charAt(0));
        }
    }//end go operand

    public void goOperator(View v){
        String operator = v.getContentDescription().toString();
        try{
            String val = numberDisplayTV.getText().toString();
            expression.setOperand1(Integer.parseInt(val));
        }
        catch (NumberFormatException nfe){
            expression.setOperand1(0);

        }
        numberDisplayTV.setText("0");
        expression.setOperator(operator);
    }

    public void goCompute(View v){
        try{
            String val = numberDisplayTV.getText().toString();
            expression.setOperand2(Integer.parseInt(val));
        }
        catch (NumberFormatException nfe){
            expression.setOperand2(0);
        }
        numberDisplayTV.setText(expression.getResult().toString());
    }
}
