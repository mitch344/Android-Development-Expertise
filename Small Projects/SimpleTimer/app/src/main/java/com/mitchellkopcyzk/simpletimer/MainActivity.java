package com.mitchellkopcyzk.simpletimer;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTime;
    private Button startBtn, stopBtn, resetBtn;
    private  WatchTime watchTime;
    private long timeInMilliseconds = 0L;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime = findViewById(R.id.textViewTimer);
        startBtn = findViewById(R.id.buttonStart);
        stopBtn = findViewById(R.id.buttonStop);
        resetBtn = findViewById(R.id.buttonReset);
        stopBtn.setEnabled(false);
        resetBtn.setEnabled(false);
        watchTime = new WatchTime();
        handler = new Handler();
    }

    private Runnable updateTimerRunnable = new Runnable() {
        @Override
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - watchTime.getStart();
            watchTime.setUpDate(watchTime.getStoredTime() + timeInMilliseconds);
            int time = (int)(watchTime.getUpDate()/1000);
            int minutes = time/60;
            int seconds = time%60;
            int millis = (int)(watchTime.getUpDate()%1000);
            //display time in textviews
            tvTime.setText(String.format("%02d", minutes)
                    + ":" + String.format("%02d",seconds)
                    + ":" + String.format("%02d",millis));
            handler.postDelayed(this,0);
        }
    };

    public void startTimer(View v)
    {
        stopBtn.setEnabled(true);
        startBtn.setEnabled(false);
        resetBtn.setEnabled(false);
        watchTime.setStart(SystemClock.uptimeMillis());
        handler.postDelayed(updateTimerRunnable, 20);
    }

    public void stopTimer(View v)
    {
        stopBtn.setEnabled(false);
        startBtn.setEnabled(true);
        resetBtn.setEnabled(true);
        watchTime.addStoredTime(timeInMilliseconds);
        handler.removeCallbacks(updateTimerRunnable);
    }

    public void resetTimer(View v)
    {
        watchTime.resetWatchTime();
        timeInMilliseconds = 0L;
        int minutes = 0;
        int seconds = 0;
        int millis = 0;
        tvTime.setText(String.format("%02d", minutes)
        + ":" + String.format("%02d",seconds)
        + ":" + String.format("%02d", millis));
    }
}
