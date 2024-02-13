package com.mitchellkopczyk.storedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private SharedPreferences sharedPreferences;
    private String p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getApplicationContext().getSharedPreferences("MyPrefs",MODE_PRIVATE);
        p = sharedPreferences.getString("key","Carole");
        Toast.makeText(this,"The name is " + p, Toast.LENGTH_LONG).show();
        etName = findViewById(R.id.editText);
    }

    public void savePrefs(View v){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String name = etName.getText().toString();
        editor.putString("key",name);
        editor.commit();
    }
}
