package com.mitchellkopcyzk.feederwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();
        if(id == R.id.insert){
            Intent i = new Intent(this,InsertActivity.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.delete){
            Intent i = new Intent(this,DeleteActivity.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.update){
            Intent i = new Intent(this,UpdateActivity.class);
            startActivity(i);
            return  true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
