package com.android.example.flushingtourapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    //Fragment for each tab
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 1: return new FoodShoppingFragment();
            case 2: return new SightSeeingFragment();
            case 3: return new HotelsFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
