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
import android.widget.TextView;

import java.util.List;

public class MyListAdapterDelete extends ArrayAdapter<Bird> {
    List<Bird> birdList;
    Context context;
    int resource;
    DatabaseManager databaseManager;

    public MyListAdapterDelete(Context context, int resource, List<Bird> birdList, DatabaseManager databaseManager) {
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

        //Set up UI
        TextView textViewID = view.findViewById(R.id.textID);
        TextView textViewType = view.findViewById(R.id.textType);
        TextView textViewQty =  view.findViewById(R.id.textQty);
        TextView textViewTimeOfDay = view.findViewById(R.id.textTOD);
        TextView textViewDate = view.findViewById(R.id.textDate);
        TextView textViewWeather = view.findViewById(R.id.textWeather);
        TextView textViewTempCelsius = view.findViewById(R.id.textTemp);
        Button buttonDelete = view.findViewById(R.id.buttonDelete);

        //Get Values for UI
        Bird bird = birdList.get(position);
        textViewID.setText("ID: " + Integer.toString(bird.getId()));
        textViewType.setText("Type: " + bird.getType());
        textViewQty.setText("Qty: " + Integer.toString(bird.getQty()));
        textViewTimeOfDay.setText("Time of Day: " +bird.getTimeOfDay());
        textViewDate.setText("Date: " + bird.getDate());
        textViewWeather.setText("Weather: " + bird.getWeather());
        textViewTempCelsius.setText("Temprature: " + Double.toString(bird.getTempCelsius()));


        //Delete the Entry
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeBird(position);
            }
        });
        return view;
    }

    private void removeBird(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int id = birdList.get(position).getId();
                databaseManager.deleteById(id);
                birdList.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("No,", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
