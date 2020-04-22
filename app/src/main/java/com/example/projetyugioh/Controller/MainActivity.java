package com.example.projetyugioh.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetyugioh.R;

public class MainActivity extends AppCompatActivity {

    private Button button,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCard();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                openRule();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBanlist();
            }
        });


    }

    public void openCard(){
        Intent intent3 = new Intent(this, AllCards.class);
        startActivity(intent3);
    }

    public void openRule(){
        Intent intent = new Intent(this, Rule.class);
        startActivity(intent);
    }

    public void openBanlist(){
        Intent intent2 = new Intent(this, Banlist.class);
        startActivity(intent2);

    }


}
