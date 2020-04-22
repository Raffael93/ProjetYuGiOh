package com.example.projetyugioh.Controller;


import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
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
import com.example.projetyugioh.R;
import com.example.projetyugioh.Model.Cards;
import com.example.projetyugioh.Model.APIclient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                startActivity(new Intent(getApplicationContext(),activity_item.class)
                        .putExtra("url",list.get(position).getUrl())
                        .putExtra("name",list.get(position).getName())
                        .putExtra("desc",list.get(position).getDesc())
                        .putExtra("type",list.get(position).getType())
                        .putExtra("atk",list.get(position).getAtk())
                        .putExtra("def",list.get(position).getDef())
                );

            }
        });

        List<Cards> listCards = loadData();

        if(listCards != null){
            showList(listCards);

        }else{
            apiCall();
        }


    }

    private void apiCall(){



        Call<List<Cards>> call = APIclient.apIinterface().getCards();

        call.enqueue(new Callback<List<Cards>>() {
            @Override
            public void onResponse(Call<List<Cards>> call, Response<List<Cards>> response) {
                if(response.isSuccessful()){
                    saveData();

                    customAdapter = new CustomAdapter(response.body(), Activity4.this);
                    gridView.setAdapter(customAdapter);



                    list = response.body();
                    //new activity
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                            startActivity(new Intent(getApplicationContext(),activity_item.class)
                                    .putExtra("url",list.get(position).getUrl())
                                    .putExtra("name",list.get(position).getName())
                                    .putExtra("desc",list.get(position).getDesc())
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


    public  void saveData(){

      SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();

        String json = gson.toJson(list);
        editor.putString("list",json);
        editor.apply();

        //Toast.makeText(getApplicationContext(),"List saved",Toast.LENGTH_SHORT).show();

    }

    public List<Cards> loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences",MODE_PRIVATE);

        Gson gson = new Gson();
        String json = sharedPreferences.getString("list",null);

        Type type = new TypeToken<List<Cards>>(){}.getType();
        list = gson.fromJson(json,type);


       // Toast.makeText(getApplicationContext(),"List loaded",Toast.LENGTH_SHORT).show();


    return list;

    }

    private void showList(List<Cards> cardsList){
        gridView = findViewById(R.id.gridview);
        customAdapter = new CustomAdapter(cardsList, Activity4.this);
        gridView.setAdapter(customAdapter);
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
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View view = LayoutInflater.from(context).inflate(R.layout.row_data,null);

            TextView name  = view.findViewById(R.id.textView);
            ImageView image = view.findViewById(R.id.imageView);

            Glide.with(context).load(list.get(position).getUrl()).into(image);

            name.setText(list.get(position).getName());

            return view;
        }
    }

}
