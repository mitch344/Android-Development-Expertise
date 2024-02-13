package com.mitchellkopczyk.tapbuttoncounter;

/*
 * model for counter create a new counter object , adds 1 to it
 */

public class Counter {
    private int cnter;

    public Counter(){
        cnter = 0;
    }

    public Integer getCnter() {
        return cnter;
    }

    public void setCnter(int cnter) {
        this.cnter = cnter;
    }

    public void addCnt(){
        cnter++;
    }
}
