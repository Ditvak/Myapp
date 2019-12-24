package com.example.myapp;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class FifthActivity extends AppCompatActivity {

    private Button StartButton;
    private Button PauseButton;
    private Button ResetButton;
    private Chronometer mChronometer;

    private long lastPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        StartButton = findViewById(R.id.start_button);
        PauseButton = findViewById(R.id.pause_button);
        ResetButton = findViewById(R.id.reset_button);
        mChronometer = findViewById(R.id.chronometer);

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastPause != 0){
                    mChronometer.setBase(mChronometer.getBase() + SystemClock.elapsedRealtime() - lastPause);
                }
                else{
                    mChronometer.setBase(SystemClock.elapsedRealtime());
                }

                mChronometer.start();
                StartButton.setEnabled(false);
                PauseButton.setEnabled(true);
            }
        });

        PauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastPause = SystemClock.elapsedRealtime();
                mChronometer.stop();
                PauseButton.setEnabled(false);
                StartButton.setEnabled(true);
            }
        });

        ResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mChronometer.stop();
                mChronometer.setBase(SystemClock.elapsedRealtime());
                lastPause = 0;
                StartButton.setEnabled(true);
                PauseButton.setEnabled(false);
            }
        });
    }
}