package com.example.projetyugioh.network;

import com.example.projetyugioh.model.Cards;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {


    @GET("api.json")
    Call<List<Cards>> getCards();
}
