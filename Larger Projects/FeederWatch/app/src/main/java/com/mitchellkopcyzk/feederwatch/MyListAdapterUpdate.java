package com.mitchellkopcyzk.feederwatch;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyListAdapterUpdate extends ArrayAdapter<Bird> {

    List<Bird> birdList;
    Context context;
    int resource;
    DatabaseManager databaseManager;

    public MyListAdapterUpdate(Context context, int resource, List<Bird> birdList, DatabaseManager databaseManager) {
        super(context, resource, birdList);
        this.context = context;
        this.resource = resource;
        this.birdList = birdList;
        this.databaseManager = databaseManager;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);

        //Set Up UI
        Button buttonUpdate = view.findViewById(R.id.buttonUpdate);
        TextView textViewID = view.findViewById(R.id.uID);
        final EditText editTextType = view.findViewById(R.id.uType);
        final EditText editTextQty = view.findViewById(R.id.uQty);
        final EditText editTextTimeOfDay = view.findViewById(R.id.uTimeOfDay);
        final EditText editTextViewDate = view.findViewById(R.id.uDate);
        final EditText editTextWeather = view.findViewById(R.id.uWeather);
        final EditText editTextTempCelsius = view.findViewById(R.id.uTempCelsius);

        //Fill the UI with values
        Bird bird = birdList.get(position);
        textViewID.setText("ID: " + Integer.toString(bird.getId()));
        editTextType.setText(bird.getType());
        editTextQty.setText(Integer.toString(bird.getQty()));
        editTextTimeOfDay.setText(bird.getTimeOfDay());
        editTextViewDate.setText(bird.getDate());
        editTextWeather.setText(bird.getWeather());
        editTextTempCelsius.setText(Double.toString(bird.getTempCelsius()));

        //Update The Entry on Click
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Are you sure you want update the entry?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = birdList.get(position).getId();

                        String type = editTextType.getText().toString();
                        int qty = Integer.parseInt(editTextQty.getText().toString());
                        String time = editTextTimeOfDay.getText().toString();
                        String date = editTextViewDate.getText().toString();
                        String weather = editTextWeather.getText().toString();
                        double temp = Double.parseDouble(editTextTempCelsius.getText().toString());

                        databaseManager.updateById(id,type,qty,time,date,weather,temp);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return view;
    }
}
