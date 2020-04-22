package com.example.projetyugioh.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {


    @GET("Raffael93/ProjetYuGiOh/master/app/src/main/java/com/example/projetyugioh/api.json")
    Call<List<Cards>> getCards();
}
