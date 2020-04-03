package com.example.projetyugioh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity3 extends AppCompatActivity {

    private Button retourMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        retourMenu = findViewById(R.id.retourMenu);

        retourMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });



    }

    public void previous(){
        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
    }
}
