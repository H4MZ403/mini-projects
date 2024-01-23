package com.example.market_place_frontend.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.market_place_frontend.R;
import com.example.market_place_frontend.model.ItemModel;

public class ProductActivity extends AppCompatActivity {
    private ImageView itemImageView;
    private ImageView backArrowImageView;
    private ImageView cartIcon;
    private TextView itemNameTextView;
    private TextView itemDescriptionTextView;
    private RatingBar itemRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.gray_bg, this.getTheme()));
        setContentView(R.layout.activity_product);

        ItemModel itemModel = getIntent().getParcelableExtra("itemModel");
        if (itemModel != null) {
            itemNameTextView = findViewById(R.id.itemPriceTextView);
            itemImageView = findViewById(R.id.itemImageView);
            itemDescriptionTextView = findViewById(R.id.itemDescriptionTextView);
            itemRatingBar = findViewById(R.id.itemRatingBar);


            itemNameTextView.setText(itemModel.getItemPrice());
            itemImageView.setImageResource(itemModel.getImageResource());
            itemDescriptionTextView.setText(itemModel.getItemDescription());
            itemRatingBar.setRating(itemModel.getRating());

            // cart icon
            cartIcon = findViewById(R.id.cart_icon);
            cartIcon.setOnClickListener(v -> startActivity(new Intent(this, CartActivity.class)));
            
            // back arrow
            backArrowImageView = findViewById(R.id.backArrow);
            backArrowImageView.setOnClickListener(v -> finish());
        }
    }
}