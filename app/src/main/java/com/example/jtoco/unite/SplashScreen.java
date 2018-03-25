package com.example.jtoco.unite;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToSignIn = new Intent(getApplicationContext(), SignIn.class);
                startActivity(goToSignIn);
                finish();

            }
        },4000);
    }
}
