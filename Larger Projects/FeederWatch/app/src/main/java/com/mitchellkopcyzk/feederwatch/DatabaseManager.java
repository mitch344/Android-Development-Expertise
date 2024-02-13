package com.mitchellkopcyzk.feederwatch;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    //Database Info
    private static final String DATABASENAME = "FeederWatch";
    private static final int VERSION = 1;

    public DatabaseManager(Context ctx){super(ctx,DATABASENAME,null,VERSION);}

    //Create the Database
    @Override
    public  void onCreate(SQLiteDatabase db){
        String sqlCreate =
                "CREATE TABLE birds (ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, Type TEXT, Qty " +
                        "INTEGER, Time TEXT, Date TEXT, Weather TEXT, TempCelsius REAL)";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS birds");
        onCreate(db);
    }

    //Insert Entry's into the database
    public void insert(Bird b) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "INSERT INTO birds(ID, Type, Qty, Time, Date, Weather, TempCelsius) VALUES (NULL,'"
                + b.getType() + "'," + b.getQty() + ",'" + b.getTimeOfDay() + "','" + b.getDate() +
                "','" + b.getWeather() + "'," + b.getTempCelsius() + ")";
        db.execSQL(sqlInsert);
        db.close();
    }

    public ArrayList<Bird> selectAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlQuery = "SELECT * FROM birds";
        Cursor c = db.rawQuery(sqlQuery,null);
        ArrayList<Bird> birds = new ArrayList<>();

        while (c.moveToNext()){
            Bird currentBird = new Bird(Integer.parseInt(c.getString(0)),
                    c.getString(1), Integer.parseInt(c.getString(2)),
                    c.getString(3), c.getString(4), c.getString(5),
                    c.getDouble(6));
            birds.add(currentBird);
        }
        db.close();
        return birds;
    }

    public Bird selectById(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlQuery = "SELECT * FROM birds WHERE ID = " + id;
        Cursor c = db.rawQuery(sqlQuery,null);
        Bird bird = null;
        if(c.moveToFirst()){
            bird = new Bird(Integer.parseInt(c.getString(0)),
                    c.getString(1), Integer.parseInt(c.getString(2)),
                    c.getString(3), c.getString(4), c.getString(5),
                    Double.parseDouble(c.getString(6)));
        }
        return bird;
    }

    public void deleteById(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        String sqlQuery = "DELETE FROM birds WHERE ID = " + id;
        db.execSQL(sqlQuery);
        db.close();
    }

    public void updateById(int id, String type, int qty,
                           String time, String date, String weather, double tempCelsius){
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlQuery = "UPDATE birds SET Type = '" + type + "', Qty =" + qty +
                ", Time = '" + time + "', Date = '" + date + "', Weather = '"
                +  weather + "', TempCelsius = " + tempCelsius + " WHERE ID =" + id;
        db.execSQL(sqlQuery);
        db.close();
    }
}