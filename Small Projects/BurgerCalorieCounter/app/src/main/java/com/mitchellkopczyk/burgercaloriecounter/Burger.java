package com.mitchellkopczyk.burgercaloriecounter;

public class Burger {
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    final static int ASIAGO = 90;
    final static int PROVOLONE = 120;
    final static int PROSCIUTTO = 115;
    private int pattyCal, cheesCal, prosciuttoCal, sauseCal;
    public Burger(){
        pattyCal = BEEF;
        cheesCal = ASIAGO;
        prosciuttoCal = 0;
        sauseCal = 0;
    }

    public void setPattyCal(int pattyCal) {
        this.pattyCal = pattyCal;
    }

    public void setCheesCal(int cheesCal) {
        this.cheesCal = cheesCal;
    }

    public void setProsciuttoCal(int prosciuttoCal) {
        this.prosciuttoCal = prosciuttoCal;
    }

    public void setSauseCal(int sauseCal) {
        this.sauseCal = sauseCal;
    }

    public void clearProsciuttoCalories(){
        prosciuttoCal = 0;
    }

    public int getTotalCalories(){
        return pattyCal + cheesCal + prosciuttoCal +sauseCal;
    }
}
