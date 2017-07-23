package com.example.aspiree15.timer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView time;
    private Button start1;
    private Button start2;
    private Button cancel;
    private CountDownTimer countDownTimer;

    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.start1 :
                    start1();
                    break;
                case R.id.start2 :
                    start2();
                    break;
                case R.id.cancel:
                    cancel();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start1 = (Button) findViewById(R.id.start1);
        start1.setOnClickListener(btnClickListener);
        start2 = (Button) findViewById(R.id.start2);
        start2.setOnClickListener(btnClickListener);
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(btnClickListener);
        time = (TextView) findViewById(R.id.time);
    }



    private void start1() {
        countDownTimer = new CountDownTimer(60 * 60 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                time.setText(hms);
            }
            public void onFinish() {
                time.setText("Done");
            }
        };
        countDownTimer.start();
    }
    private void start2() {
        countDownTimer = new CountDownTimer(120 * 60 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                time.setText(hms);
            }
            public void onFinish() {
                time.setText("Done");
            }
        };
        countDownTimer.start();
    }

    private  void cancel() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }
}
