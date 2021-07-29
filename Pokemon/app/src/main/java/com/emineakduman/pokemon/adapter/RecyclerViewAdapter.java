package com.emineakduman.pokemon.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.emineakduman.pokemon.R;
import com.emineakduman.pokemon.model.CharacterModel;
import com.emineakduman.pokemon.view.DetailsActivity;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {
    private ArrayList<CharacterModel> characterList;
   private  Context context;



    public RecyclerViewAdapter(ArrayList<CharacterModel> characterList,Context context) {
        this.characterList = characterList;
        this.context=context;
    }

    @NonNull

    @Override
    public RowHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewAdapter.RowHolder holder, int position) {



      Glide.with(context).load(characterList.get(position).getImageUrl()).apply(new RequestOptions().centerCrop()).into(holder.imageView);
        holder.textName.setText(characterList.get(position).getName());
        holder.description.setText(characterList.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("imageUrl",characterList.get(position).getImageUrl());
                intent.putExtra("description",characterList.get(position).getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textName;
        TextView description;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
            textName=itemView.findViewById(R.id.text_name);
            description=itemView.findViewById(R.id.text_description);

        }

    }
}