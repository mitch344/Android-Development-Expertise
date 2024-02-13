package com.mitchellkopcyzk.simpleweatherapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private JSONObject myObj;
    private JSONArray myArray;
    private JsonParser myParser = new JsonParser();
    private String temp;
    private TextView tempTV, windTV;
    private final static String OPEN_WEATHER_MAP_API =
            "http://api.openweathermap.org/data/2.5/weather?q=Chicago&APPID=8e3690b090f8d613f4f6b44f3d9faf1e";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempTV = findViewById(R.id.textViewTemp);
    }

    @Override
    protected void onResume(){
        super.onResume();
        new DownloadJson().execute();
    }

    private class DownloadJson extends AsyncTask<String,Void,String>
    {
        @Override
        protected String doInBackground(String... strings) {
            myObj = myParser.getJSONFromUrl(OPEN_WEATHER_MAP_API);
            return "End of do in background";
        }

        @Override
        protected void onPostExecute(String result){
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
            try{
                myArray = myObj.getJSONArray("weather");
                JSONObject tempObj = myObj.getJSONObject("main");
                temp = tempObj.getString("temp");
                tempTV.setText(temp);
            }
            catch (JSONException jse){
                tempTV.setText("Error parsing json");
            }
        }
    }
}
