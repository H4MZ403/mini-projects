package com.example.market_place_frontend.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.market_place_frontend.R;
import com.example.market_place_frontend.activity.ProductActivity;
import com.example.market_place_frontend.model.ItemModel;

public class WishedItemsAdapter extends RecyclerView.Adapter<WishedItemsAdapter.ImageViewHolder> {

    private ItemModel[] itemModels;
    private Context context;

    public WishedItemsAdapter(ItemModel[] itemModels, Context context) {
        this.itemModels = itemModels;
        this.context = context;
    }

    @Override
    public WishedItemsAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wished, parent, false);
        return new WishedItemsAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WishedItemsAdapter.ImageViewHolder holder, int position) {
        ItemModel itemModel = itemModels[position];
        holder.imageView.setImageResource(itemModel.getImageResource());
        holder.wishedItemPrice.setText(itemModel.getItemPrice());

        holder.imageView.setOnClickListener(v -> {
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
        TextView wishedItemPrice;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.wishedItemImageView);
            wishedItemPrice = itemView.findViewById(R.id.wishedItemPrice);
        }
    }
}
