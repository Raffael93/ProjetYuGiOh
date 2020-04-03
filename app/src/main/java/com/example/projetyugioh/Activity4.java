package com.example.projetyugioh;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.projetyugioh.model.Cards;
import com.example.projetyugioh.network.APIclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Activity4 extends AppCompatActivity {

    GridView gridView;
    CustomAdapter customAdapter;
    public static List<Cards> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        gridView = findViewById(R.id.gridview);
        list = new ArrayList<>();


        Call<List<Cards>> call = APIclient.apIinterface().getAnimals();

        call.enqueue(new Callback<List<Cards>>() {
            @Override
            public void onResponse(Call<List<Cards>> call, Response<List<Cards>> response) {
                if(response.isSuccessful()){

                    list = response.body();

                    customAdapter = new CustomAdapter(response.body(), Activity4.this);
                    gridView.setAdapter(customAdapter);

                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Intent intent = new Intent();
                           // intent.putExtra("atk",list.get(position).getAtk());
                            //intent.putExtra("def",list.get(position).getDef());
                            //intent.putExtra("name",list.get(position).getName());
                            //intent.putExtra("image_url",list.get(position).getLink());

                            startActivity(new Intent(getApplicationContext(),activity_item.class)
                                    .putExtra("name",list.get(position).getName())
                                    .putExtra("image_url",list.get(position).getLink())
                                    .putExtra("desc",list.get(position).getDesc())
                                    .putExtra("race",list.get(position).getRace())
                                    .putExtra("type",list.get(position).getType())
                                    );

                        }
                    });


                }else{
                    Toast.makeText(getApplicationContext(),"An error : ",Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<List<Cards>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"An error : "+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }

    public class CustomAdapter extends BaseAdapter{

        public List<Cards> list;
        public Context context;

        public CustomAdapter(List<Cards> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = LayoutInflater.from(context).inflate(R.layout.row_data,null);

            TextView name  = view.findViewById(R.id.textView);
            ImageView image_url_small = view.findViewById(R.id.imageView);

            name.setText(list.get(position).getName());

            Glide.with(context).load(list.get(position).getLink()).into(image_url_small);

            return view;
        }
    }

}
