package com.cs50.finalprojectcs50.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.cs50.finalprojectcs50.R;
import com.cs50.finalprojectcs50.adapter.PagerAdapter;
import com.cs50.finalprojectcs50.database.CategoryDatabase;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private static CategoryDatabase categoryDatabase;
    private PagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        categoryDatabase = Room.databaseBuilder(getApplicationContext(), CategoryDatabase.class, "categories")
//                .allowMainThreadQueries()
//                .build();

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}