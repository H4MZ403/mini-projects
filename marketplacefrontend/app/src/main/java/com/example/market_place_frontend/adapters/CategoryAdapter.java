package com.example.market_place_frontend.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market_place_frontend.R;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private final String[] categories;
    private int selectedPosition = RecyclerView.NO_POSITION;
    private Context context;

    public CategoryAdapter(String[] categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String category = categories[position];

        holder.category_tv.setText(category);
        if (position == selectedPosition) {
            holder.category_tv.setBackgroundResource(R.drawable.custom_category_option_selected);
            holder.category_tv.setTextColor(context.getResources().getColor(R.color.white, context.getTheme()));
        } else {
            holder.category_tv.setBackgroundResource(R.drawable.custom_category_option);
            holder.category_tv.setTextColor(context.getResources().getColor(R.color.blue, context.getTheme()));
        }

        holder.category_tv.setOnClickListener(v -> {
            System.out.println("Category TextView is Clicked");
            // Update the selection
            notifyItemChanged(selectedPosition);
            selectedPosition = position;
            notifyItemChanged(selectedPosition);


            String selectedCategory = categories[selectedPosition];
            Toast.makeText(context, "Category: " + selectedCategory, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView category_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category_tv = itemView.findViewById(R.id.category_et);
        }
    }
}