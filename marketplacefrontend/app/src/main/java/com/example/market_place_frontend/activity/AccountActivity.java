package com.example.market_place_frontend.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.market_place_frontend.R;
import com.example.market_place_frontend.adapters.WishedItemsAdapter;
import com.example.market_place_frontend.model.ItemModel;

public class AccountActivity extends AppCompatActivity {
    RecyclerView recyclerviewWishedItem;
    ImageView imageViewNotificationIcon;
    ImageView imageViewSettingIcon;
    private final ItemModel[] itemModels = {
            new ItemModel("$159.9", "Product 1 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_1, 2),
            new ItemModel("$129.9", "Product 2 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_3, 4),
            new ItemModel("$259.9", "Product 3 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_1, 5f),
            new ItemModel("$599.9", "Product 4 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_3, 1f),
            new ItemModel("$599.9", "Product 4 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_3, 1f),
            new ItemModel("$599.9", "Product 4 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_3, 1f),
            new ItemModel("$599.9", "Product 4 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_3, 1f),
            new ItemModel("$599.9", "Product 4 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_3, 1f),
            new ItemModel("$599.9", "Product 4 Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                    "molestiae quas vel sint commodi repudiandae consequuntur", R.drawable.image_3, 1f)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.gray_bg, this.getTheme()));
        setContentView(R.layout.activity_account);

        recyclerviewWishedItem = findViewById(R.id.recyclerviewWishedItem);
        initRecyclerView(R.id.recyclerviewWishedItem, new GridLayoutManager(this, 2), new WishedItemsAdapter(itemModels, this));

        // notification icon click listener
        imageViewNotificationIcon = findViewById(R.id.notification_icon);
        imageViewNotificationIcon.setOnClickListener(v -> startActivity(new Intent(AccountActivity.this, NotificationActivity.class)));

        // setting icon click listener
        imageViewSettingIcon = findViewById(R.id.setting_icon);
        imageViewSettingIcon.setOnClickListener(v -> startActivity(new Intent(AccountActivity.this, SettingActivity.class)));
    }

    private <T extends RecyclerView.Adapter<?>> void initRecyclerView(int recyclerViewId, RecyclerView.LayoutManager layoutManager, T adapter) {
        RecyclerView recyclerView = findViewById(recyclerViewId);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}