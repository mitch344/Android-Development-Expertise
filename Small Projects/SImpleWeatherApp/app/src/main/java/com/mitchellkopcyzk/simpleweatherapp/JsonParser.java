//Key: 8e3690b090f8d613f4f6b44f3d9faf1e
package com.mitchellkopcyzk.simpleweatherapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonParser {
    private static InputStream is = null;
    private static JSONObject jObj = null;
    private URL urlIn;
    private String json = "json String";

    public JsonParser() {
        //empty constructor
    }

    public  JSONObject getJSONFromUrl(String url)
    {
        HttpURLConnection urlConnection;
        try {
            urlIn = new URL(url);
            urlConnection = (HttpURLConnection)urlIn.openConnection();
            is = new BufferedInputStream(urlConnection.getInputStream());
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line=reader.readLine()) != null){
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        }
        catch (MalformedURLException mfe) {
            mfe.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                jObj = new JSONObject(json);
            }
            catch (JSONException je){
                je.printStackTrace();
            }
        }
        return jObj;
    }
}
