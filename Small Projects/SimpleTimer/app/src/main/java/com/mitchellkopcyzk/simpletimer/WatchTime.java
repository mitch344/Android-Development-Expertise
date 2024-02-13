package com.mitchellkopcyzk.simpletimer;

public class WatchTime
{
    private long start, upDate, storedTime;
    public WatchTime()
    {
        start = 0L;
        upDate = 0L;
        storedTime = 0L;
    }
    public void resetWatchTime()
    {
        start = 0L;
        upDate = 0L;
        storedTime = 0L;
    }
    public long getStart()
    {
        return start;
    }
    public void setStart(long start)
    {
        this.start = start;
    }
    public long getUpDate()
    {
        return upDate;
    }

    public void setUpDate(long upDate)
    {
        this.upDate = upDate;
    }
    public long getStoredTime()
    {
        return storedTime;
    }
    public void addStoredTime(long milli)
    {
        this.storedTime += milli;
    }
}