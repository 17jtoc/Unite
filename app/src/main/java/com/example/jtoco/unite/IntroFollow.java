package com.example.jtoco.unite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class IntroFollow extends AppCompatActivity {


    private ImageButton b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_follow);

        b = (ImageButton)findViewById(R.id.followbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(IntroFollow.this,CategorySelection.class);
                startActivity(m);
            }
        });
    }
}