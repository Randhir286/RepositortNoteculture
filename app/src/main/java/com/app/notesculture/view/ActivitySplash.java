package com.app.notesculture.view;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.app.notesculture.R;

public class ActivitySplash extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Hiding Title bar of this activity screen */
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        /** Making this activity, full screen */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /** Sets a layout for this activity */
        setContentView(R.layout.activity_splash);

        /** Creates a count down timer, which will be expired after 5000 milliseconds */
        new CountDownTimer(5000,1000) {

            /** This method will be invoked on finishing or expiring the timer */
            @Override
            public void onFinish() {
                /** Creates an intent to start new activity */
                Intent intent = new Intent(getBaseContext(), ActivityWelcome.class);

                /** Creates a new activity, on finishing this timer */
                startActivity(intent);

                /** Close this activity screen */
                finish();
            }

            /** This method will be invoked in every 1000 milli seconds until
             * this timer is expired.Because we specified 1000 as tick time
             * while creating this CountDownTimer
             */
            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();

    }

}
