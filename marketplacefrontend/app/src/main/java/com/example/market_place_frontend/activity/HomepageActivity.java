package com.example.market_place_frontend.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market_place_frontend.R;
import com.example.market_place_frontend.adapters.BestItemsAdapter;
import com.example.market_place_frontend.adapters.CategoryAdapter;
import com.example.market_place_frontend.adapters.NewProductsAdapter;
import com.example.market_place_frontend.model.ItemModel;

public class HomepageActivity extends AppCompatActivity {
    private ImageView imageViewCartIcon;
    private ImageView imageViewNotification;
    private ImageView imageViewProfileImageView;
    private TextView showMoreTv;
    private final String[] categories = {"Men", "Women", "Sport", "Shoes", "Accessories", "Electronics"};
    private final int[] imageResources = {R.drawable.image_6, R.drawable.image_7, R.drawable.image_6, R.drawable.image_7};
    private final ItemModel[] itemModels2 = {
            new ItemModel("$159.9", "Product 1 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_6, 2),
            new ItemModel("$159.9", "Product 1 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_7, 2),
            new ItemModel("$159.9", "Product 1 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_6, 2),
            new ItemModel("$159.9", "Product 1 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_7, 2)
    };
    private final ItemModel[] itemModels = {
            new ItemModel("$159.9", "Product 1 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_1, 2),
            new ItemModel("$129.9", "Product 2 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_3, 4),
            new ItemModel("$259.9", "Product 3 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_1, 5f),
            new ItemModel("$599.9", "Product 4 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_3, 1f),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.gray_bg, this.getTheme()));
        setContentView(R.layout.activity_homepage);

        initRecyclerView(R.id.recyclerViewBestItems, new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false), new BestItemsAdapter(itemModels2, this));
        initRecyclerView(R.id.recyclerViewCategories, new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false), new CategoryAdapter(categories, this));
        initRecyclerView(R.id.recyclerViewNewProducts, new GridLayoutManager(this, 2), new NewProductsAdapter(itemModels, this));

        // cart icon click listener
        imageViewCartIcon = findViewById(R.id.cart_icon);
        imageViewCartIcon.setOnClickListener(v -> startActivity(new Intent(HomepageActivity.this, CartActivity.class)));

        // notification icon click listener
        imageViewNotification = findViewById(R.id.notification_icon);
        imageViewNotification.setOnClickListener(
                v -> startActivity(new Intent(HomepageActivity.this, NotificationActivity.class))
        );

        // profile icon click listener
        imageViewProfileImageView = findViewById(R.id.profileImageView);
        imageViewProfileImageView.setOnClickListener(v -> {
            startActivity(new Intent(HomepageActivity.this, AccountActivity.class));
        });

        // show more underline textView
        showMoreTv = findViewById(R.id.showMoreTextView);
        showMoreTextViewWithUnderline("Show more");
    }

    private <T extends RecyclerView.Adapter<?>> void initRecyclerView(int recyclerViewId, RecyclerView.LayoutManager layoutManager, T adapter) {
        RecyclerView recyclerView = findViewById(recyclerViewId);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void showMoreTextViewWithUnderline(String textContent) {
        SpannableString content = new SpannableString(textContent);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        showMoreTv.setText(content);
    }
}
