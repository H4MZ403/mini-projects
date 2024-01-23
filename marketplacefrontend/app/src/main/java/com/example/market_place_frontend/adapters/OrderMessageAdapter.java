package com.example.market_place_frontend.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.market_place_frontend.R;
import com.example.market_place_frontend.model.MessageModel;

public class OrderMessageAdapter extends RecyclerView.Adapter<OrderMessageAdapter.ImageViewHolder> {

    private MessageModel[] messageModels;
    private Context context;

    public OrderMessageAdapter(MessageModel[] messageModels, Context context) {
        this.messageModels = messageModels;
        this.context = context;
    }

    @Override
    public OrderMessageAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_message, parent, false);
        return new OrderMessageAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderMessageAdapter.ImageViewHolder holder, int position) {
        MessageModel messageModel = messageModels[position];

        holder.messageTitle.setText(messageModel.getTitle());
        holder.messageDescription.setText(messageModel.getDescription());
        holder.messageDate.setText(messageModel.getDateAsString());
    }

    @Override
    public int getItemCount() {
        return messageModels.length;
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView messageTitle;
        TextView messageDescription;
        TextView messageDate;

        public ImageViewHolder(View itemView) {
            super(itemView);
            messageTitle = itemView.findViewById(R.id.orderMessageTitle);
            messageDescription = itemView.findViewById(R.id.orderMessageDescription);
            messageDate = itemView.findViewById(R.id.orderMessageDate);
        }
    }
}
