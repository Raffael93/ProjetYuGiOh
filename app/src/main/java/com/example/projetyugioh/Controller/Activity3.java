package com.example.projetyugioh.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projetyugioh.R;
import com.example.projetyugioh.Model.RecyclerViewAdapter;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImagesUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        initImage();

        setButtons();


    }

    private void setButtons() {


    }

    public void removeItem(int position){
        mNames.remove(position);
        mImagesUrls.remove(position);


    }

    private void initImage(){

        mNames.add("Armageddon Knight");
        mImagesUrls.add("https://storage.googleapis.com/ygoprodeck.com/pics/28985331.jpg");

        mNames.add("Daigusto Emeral");
        mImagesUrls.add("https://storage.googleapis.com/ygoprodeck.com/pics/581014.jpg");

        mNames.add("Dark Grepher");
        mImagesUrls.add("https://storage.googleapis.com/ygoprodeck.com/pics/14536035.jpg");

        mNames.add("Eclipse Wyvern");
        mImagesUrls.add("https://storage.googleapis.com/ygoprodeck.com/pics/51858306.jpg");

        mNames.add("Elder Entity Norden");
        mImagesUrls.add("https://storage.googleapis.com/ygoprodeck.com/pics/17412721.jpg");

        mNames.add("Infernity Archfiend");
        mImagesUrls.add("https://storage.googleapis.com/ygoprodeck.com/pics/99177923.jpg");

        mNames.add("Nekroz of Unicore");
        mImagesUrls.add("https://storage.googleapis.com/ygoprodeck.com/pics/89463537.jpg");

        mNames.add("Dimension of Chaos");
        mImagesUrls.add("https://storage.googleapis.com/ygoprodeck.com/pics/7563579.jpg");

        initRecyclerView();

    }

    private void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mNames,mImagesUrls,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }


}
