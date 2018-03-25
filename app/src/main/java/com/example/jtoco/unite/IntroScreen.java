package com.example.jtoco.unite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class IntroScreen extends AppCompatActivity {

    private ImageButton b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_screen);

        b = findViewById(R.id.forwardButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToIntroFollow = new Intent(IntroScreen.this,IntroFollow.class);
                startActivity(goToIntroFollow);
            }
        });
    }
}
