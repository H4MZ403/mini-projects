package com.example.market_place_frontend.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.market_place_frontend.R;
import com.example.market_place_frontend.activity.ProductActivity;
import com.example.market_place_frontend.model.ItemModel;

public class BestItemsAdapter extends RecyclerView.Adapter<BestItemsAdapter.ImageViewHolder> {
    private ItemModel[] itemModels;
    private Context context;

    public BestItemsAdapter(ItemModel[] itemModels, Context context) {
        this.itemModels = itemModels;
        this.context = context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homepage, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        ItemModel itemModel = itemModels[position];
        holder.imageView.setImageResource(itemModel.getImageResource());

        holder.imageView.setOnClickListener(v-> {
            Intent intent = new Intent(context, ProductActivity.class);
            intent.putExtra("itemModel", itemModel);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return itemModels.length;
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
