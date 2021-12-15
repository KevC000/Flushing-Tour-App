package com.android.example.flushingtourapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.example.flushingtourapp.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Binding for tab layouts and view pager
        tabLayout = binding.tabsLayout;
        viewPager2 = binding.viewPager2;

        //Fragment manager and adapter
        FragmentManager fm = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);

        //Set text for each tab
        tabLayout.addTab(tabLayout.newTab().setText(R.string.home_tab));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.food_shopping_tab));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.sightseeing_tab));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.hotels_tab));

//Tab selector and swipe
tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager2.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});

viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
    @Override
    public void onPageSelected(int position) {
        tabLayout.selectTab(tabLayout.getTabAt(position));
    }
});
    }
}