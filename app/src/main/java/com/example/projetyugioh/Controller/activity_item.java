package com.example.projetyugioh.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projetyugioh.R;


public class activity_item extends AppCompatActivity {

    private TextView textView;
    private TextView descView;
    private TextView raceView;
    private TextView typeView;
    private ImageView imageView;
    private TextView atkView;
    private TextView defView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        //Link
        textView = findViewById(R.id.name);
        descView = findViewById(R.id.desc);
        imageView = findViewById(R.id.image);
        raceView = findViewById(R.id.race);
        typeView = findViewById(R.id.type);
        atkView = findViewById(R.id.atk);
        defView = findViewById(R.id.def);

        Intent intent = getIntent();

        //Beginning
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        String race = intent.getStringExtra("race");
        String type = intent.getStringExtra("type");
        String atk = intent.getStringExtra("atk");
        String def = intent.getStringExtra("def");

        //Set data
        textView.setText("Name : "+name);
        descView.setText("Description : "+ desc);
        raceView.setText("Race : "+race);
        typeView.setText("Type :"+type);
        atkView.setText("Atk : "+atk);
        defView.setText("Def : "+def);



        //Image
        String image = intent.getStringExtra("url");
        Glide.with(this).load(image).into(imageView);






    }
}
