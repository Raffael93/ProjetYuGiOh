package com.example.projetyugioh.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIclient {

    public static String base_url ="https://db.ygoprodeck.com/";


    public static Retrofit getClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }


    public static APIinterface apIinterface(){
        return getClient().create(APIinterface.class);
    }



}
