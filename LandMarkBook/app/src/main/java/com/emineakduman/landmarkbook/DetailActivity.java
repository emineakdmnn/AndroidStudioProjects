package com.emineakduman.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//import static com.emineakduman.landmarkbook.MainActivity.selectedImage;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView landMarkNameText=findViewById(R.id.landMarkNameText);
        TextView countryNameTaxt= findViewById(R.id.countryNameText);

        Intent  intent = getIntent();
        String landmarkName= intent.getStringExtra("name");
        String countryName=intent.getStringExtra("country");

        landMarkNameText.setText(landmarkName);
        countryNameTaxt.setText(countryName);
        Singleton singleton= Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());
          //imageView.setImageBitmap(selectedImage);

    }
}