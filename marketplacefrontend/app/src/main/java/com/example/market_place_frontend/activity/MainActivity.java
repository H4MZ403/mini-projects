package com.example.market_place_frontend.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.market_place_frontend.R;

public class MainActivity extends AppCompatActivity {
    Button loginButton;
    Button registerButton;
    Button cartButton;
    Button homepageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.gray_bg, this.getTheme()));
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.login_btn);
        registerButton = findViewById(R.id.register_btn);
        cartButton = findViewById(R.id.cart_button);
        homepageButton = findViewById(R.id.homepage_btn);

        loginButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });
        registerButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
        });
        cartButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CartActivity.class));
        });
        homepageButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, HomepageActivity.class));
        });
    }
}