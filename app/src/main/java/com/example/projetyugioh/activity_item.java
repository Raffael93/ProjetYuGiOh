package com.example.projetyugioh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class activity_item extends AppCompatActivity {

    TextView textView;
    TextView descView;
    TextView raceView;
    TextView typeView;
    ImageView imageView;



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


        Intent intent =getIntent();

        //Beginning
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        String race = intent.getStringExtra("race");
        String type = intent.getStringExtra("type");

        //Set data
        textView.setText("Name : "+name);
        descView.setText("Description : "+ desc);
        raceView.setText("Race : "+race);
        typeView.setText("Type :"+type);



        //Image
        String image = intent.getStringExtra("url");
        Glide.with(this).load(image).into(imageView);






    }
}
