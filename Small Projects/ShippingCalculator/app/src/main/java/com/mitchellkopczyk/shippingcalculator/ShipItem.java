package com.mitchellkopczyk.shippingcalculator;
/*
Model for the shipping calculator
 */

public class ShipItem {
    //constants
    static final Double BASE = 3.00;
    static final Double ADDED = 0.50;
    static final int BASE_WEIGHT = 16;
    static final double EXTRA_OUNCES = 4.0;
    //data members
    private Integer weight;
    private Double baseCost;
    private Double addedCost;
    private Double totalCost;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
        computeCost();
    }

    private void computeCost() {
        addedCost = 0.0;
        baseCost = BASE;
        if(weight <= 0.0){
            baseCost = 0.0;
        }
        else if (weight > BASE_WEIGHT){
            addedCost = Math.ceil((double) (weight - BASE_WEIGHT)/EXTRA_OUNCES) * ADDED;
        }
        totalCost = baseCost + addedCost;
    }

    public Double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(Double baseCost) {
        this.baseCost = baseCost;
    }

    public Double getAddedCost() {
        return addedCost;
    }

    public void setAddedCost(Double addedCost) {
        this.addedCost = addedCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public ShipItem(){
    
        weight = 0;
        baseCost = BASE;
        addedCost = 0.0;
        totalCost = 0.0;
    }
    
    
    
}
