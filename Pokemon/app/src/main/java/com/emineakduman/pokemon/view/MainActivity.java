package com.emineakduman.pokemon.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.emineakduman.pokemon.R;
import com.emineakduman.pokemon.adapter.RecyclerViewAdapter;
import com.emineakduman.pokemon.model.CharacterModel;
import com.emineakduman.pokemon.service.CharacterAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<CharacterModel> characterModels;
    private String BASE_URL="https://gist.githubusercontent.com/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        localData();

    }

    private void localData(){
       final CharacterAPI characterAPI = retrofit.create(CharacterAPI.class);
       compositeDisposable = new CompositeDisposable();
       compositeDisposable.add(characterAPI.getData()
                          .subscribeOn(Schedulers.io())
                           .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(this::handleResponse));
/*
//retrofit
        Call<List<CharacterModel>> call= characterAPI.getData();
        call.enqueue(new Callback<List<CharacterModel>>() {
            @Override
            public void onResponse(Call<List<CharacterModel>> call, Response<List<CharacterModel>> response) {
                if(response.isSuccessful()){
                    List<CharacterModel> responseList = response.body();
                    characterModels = new ArrayList<>(responseList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerViewAdapter= new RecyclerViewAdapter(characterModels,getApplicationContext());
                    recyclerView.setAdapter(recyclerViewAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<CharacterModel>> call, Throwable t) {
               t.printStackTrace();
            }
        });
*/
    }

    private void handleResponse(List<CharacterModel> characterModelList){

        characterModels = new ArrayList<>(characterModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewAdapter= new RecyclerViewAdapter(characterModels,getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

}