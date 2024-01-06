package com.example.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView title;
    private Button musicBtn;
    private Boolean isPlaying;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musicBtn = findViewById(R.id.stopBtn);
        title = findViewById(R.id.titleText);
        isPlaying = false;
        musicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPlaying = !isPlaying;
                Intent serviceIntent = new Intent(getApplicationContext(), MyCustomService.class);
                if (isPlaying){
                    musicBtn.findViewById(R.id.stopBtn).setBackgroundResource(R.drawable.baseline_stop_circle_24);
                    startService(serviceIntent);

                }
                else{
                    musicBtn.findViewById(R.id.stopBtn).setBackgroundResource(R.drawable.baseline_play_circle_24);
                    stopService(serviceIntent);
                    }
            }
        });

    }
}