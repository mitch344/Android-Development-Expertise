package com.mitchellkopcyzk.feederwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DeleteActivity extends AppCompatActivity {
    private DatabaseManager databaseManager;
    List<Bird> birdList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        databaseManager = new DatabaseManager(this);

        birdList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);

        ArrayList<Bird> birdies = databaseManager.selectAll();
        for(Bird t : birdies){
            birdList.add(t);
        }

        //Create are ListAdapter
        MyListAdapterDelete adapterDelete = new MyListAdapterDelete(this,R.layout.delete_custom_list,birdList,databaseManager);
        listView.setAdapter(adapterDelete);
    }
}
