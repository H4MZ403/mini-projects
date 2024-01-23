package com.example.market_place_frontend.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.market_place_frontend.fragment.OrderFragment;
import com.example.market_place_frontend.fragment.PromotionFragment;

public class NotificationFragmentAdapter extends FragmentStateAdapter {
    public NotificationFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1)
            return new PromotionFragment();
        return new OrderFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
