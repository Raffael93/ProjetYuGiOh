package com.example.projetyugioh.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetyugioh.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Activity2 extends AppCompatActivity {

    private Button buttonRetour;
    private PDFView pdfview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        pdfview = findViewById(R.id.pdfview);
        pdfview.fromAsset("rule.pdf").load();


        buttonRetour = findViewById(R.id.buttonRetour);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });
    }

    public void previous(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
