package com.cs50.finalprojectcs50.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.cs50.finalprojectcs50.fragment.PagerFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public static PagerAdapter INSTANCE;
    public PagerAdapter(FragmentManager fm) {
        super(fm);
        INSTANCE = this;
    }

    public static PagerAdapter getInstance() {
        return INSTANCE;
    }

    private static String[] pagerNames = {"DAY", "WEEK", "MONTH", "ALL"};

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putInt("pageIndex", i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return pagerNames.length;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pagerNames[position];
    }
}
