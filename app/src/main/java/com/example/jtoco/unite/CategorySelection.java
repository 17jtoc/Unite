package com.example.jtoco.unite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CategorySelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_selection);

        ImageButton sports=findViewById(R.id.imageButton);
        ImageButton movies=findViewById(R.id.imageButton2);
        ImageButton music=findViewById(R.id.imageButton3);
        ImageButton animals=findViewById(R.id.imageButton4);
        ImageButton books=findViewById(R.id.imageButton5);
        ImageButton tv=findViewById(R.id.imageButton6);
        ImageButton art=findViewById(R.id.imageButton7);
        ImageButton games=findViewById(R.id.imageButton8);


        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sportsb=new Intent(CategorySelection.this,Sports.class);
                startActivity(sportsb);
            }
        });

        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moviesb=new Intent(CategorySelection.this,Movies.class);
                startActivity(moviesb);
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent musicb=new Intent(CategorySelection.this,Music.class);
                startActivity(musicb);
            }
        });
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent animalsb=new Intent(CategorySelection.this,Animals.class);
                startActivity(animalsb);
            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent booksb=new Intent(CategorySelection.this,Books.class);
                startActivity(booksb);
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tvb=new Intent(CategorySelection.this,TvShows.class);
                startActivity(tvb);
            }
        });
        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artb=new Intent(CategorySelection.this,Art.class);
                startActivity(artb);
            }
        });
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gamesb=new Intent(CategorySelection.this,Games.class);
                startActivity(gamesb);
            }
        });

    }
}
