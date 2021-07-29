package com.emineakduman.pokemon.view;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.emineakduman.pokemon.R;


public class DetailsActivity extends AppCompatActivity {
    private ImageView img;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img= findViewById(R.id.image_detail);
        desc=findViewById(R.id.textView);

       desc.setText(getIntent().getStringExtra("description"));
        if(getIntent().hasExtra("imageUrl")){
            String image = getIntent().getStringExtra("imageUrl");
            Glide.with(this).asBitmap().load(image).into(img);
        }
    }

}