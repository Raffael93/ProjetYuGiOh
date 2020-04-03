package com.example.projetyugioh;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.projetyugioh.model.Animals;
import com.example.projetyugioh.network.APIclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Activity4 extends AppCompatActivity {

    GridView gridView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        gridView = findViewById(R.id.gridview);


        Call<List<Animals>> call = APIclient.apIinterface().getAnimals();

        call.enqueue(new Callback<List<Animals>>() {
            @Override
            public void onResponse(Call<List<Animals>> call, Response<List<Animals>> response) {
                if(response.isSuccessful()){
                    customAdapter = new CustomAdapter(response.body(), Activity4.this);
                    gridView.setAdapter(customAdapter);

                }else{
                    Toast.makeText(getApplicationContext(),"An error : ",Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<List<Animals>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"An error : "+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }

    public class CustomAdapter extends BaseAdapter{

        public List<Animals> list;
        public Context context;

        public CustomAdapter(List<Animals> list, Context context) {
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
            ImageView image = view.findViewById(R.id.imageView);

            name.setText(list.get(position).getName());

            Glide.with(context).load(list.get(position).getLink()).into(image);

            return view;
        }
    }

}
