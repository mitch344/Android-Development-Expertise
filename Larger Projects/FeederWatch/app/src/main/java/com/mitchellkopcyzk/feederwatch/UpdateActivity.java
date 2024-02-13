package com.mitchellkopcyzk.feederwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UpdateActivity extends AppCompatActivity {
    private DatabaseManager databaseManager;
    List<Bird> birdList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        databaseManager = new DatabaseManager(this);

        birdList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.uListView);

        ArrayList<Bird> birdies = databaseManager.selectAll();
        for(Bird t : birdies){
            birdList.add(t);
        }

        //Create are ListAdapter
        MyListAdapterUpdate adapterUpdate = new MyListAdapterUpdate(this,R.layout.update_custom_list,birdList,databaseManager);
        listView.setAdapter(adapterUpdate);
    }
}
