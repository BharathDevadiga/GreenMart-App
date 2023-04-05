package com.example.greenmart.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.greenmart.R;
import com.example.greenmart.activities.ViewAllActivity;
import com.example.greenmart.models.FlowerModel;
import com.example.greenmart.models.RecommendedModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FlowerAdapters extends RecyclerView.Adapter<FlowerAdapters.ViewHolder> {


    Context context;
    List<FlowerModel> flowerModelList;

    public FlowerAdapters(Context context, List<FlowerModel>flowerModelList) {
        this.context = context;
        this.flowerModelList = flowerModelList;
    }

    @NonNull
    @NotNull
    @Override
    public FlowerAdapters.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType)
    {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FlowerAdapters.ViewHolder holder, int position) {
        Glide.with(context).load(flowerModelList.get(position).getImg_url()).into(holder.imageView);
        holder.name.setText(flowerModelList.get(position).getName());
        holder.description.setText(flowerModelList.get(position).getDescription());
        holder.rating.setText(flowerModelList.get(position).getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAllActivity.class);
                intent.putExtra("type",flowerModelList.get(position).getType());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return flowerModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,description,rating;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.flo_img);
            name = itemView.findViewById(R.id.flo_name);
            description = itemView.findViewById(R.id.flo_dec);
            rating = itemView.findViewById(R.id.flo_rating);
        }
    }
}
