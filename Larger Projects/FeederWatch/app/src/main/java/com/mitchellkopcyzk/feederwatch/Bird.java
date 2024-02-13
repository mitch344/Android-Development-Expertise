package com.mitchellkopcyzk.feederwatch;

//This is the model for the poject

public class Bird {
    private int id;
    private String type;
    private int qty;
    private String timeOfDay;
    private String date;
    private String weather;
    private double tempCelsius;

    public Bird(int id, String type, int qty, String timeOfDay,
                String date, String weather, double tempCelsius) {
        this.id = id;
        this.type = type;
        this.qty = qty;
        this.timeOfDay = timeOfDay;
        this.date = date;
        this.weather = weather;
        this.tempCelsius = tempCelsius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty= qty;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getTempCelsius() {
        return tempCelsius;
    }

    public void setTempCelsius(double tempCelsius) {
        this.tempCelsius = tempCelsius;
    }
}