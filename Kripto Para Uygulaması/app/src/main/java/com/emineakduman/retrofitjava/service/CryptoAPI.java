package com.emineakduman.retrofitjava.service;

import com.emineakduman.retrofitjava.model.CryptoModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {
     @GET("prices?key=81600db288063d26d32a2fde16ac741469056ea5")
   // Call<List<CryptoModel>>getData();
    Observable <List<CryptoModel>> getData();
}

