package com.emineakduman.pokemon.service;

import com.emineakduman.pokemon.model.CharacterModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterAPI {

    @GET("DavidCorrado/8912aa29d7c4a5fbf03993b32916d601/raw/681ef0b793ab444f2d81f04f605037fb44814125/pokemon.json")

    //Call<List<CharacterModel>> getData();
    Observable<List<CharacterModel>> getData();
}
