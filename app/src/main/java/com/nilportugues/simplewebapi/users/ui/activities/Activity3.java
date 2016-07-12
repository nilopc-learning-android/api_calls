package com.nilportugues.simplewebapi.users.ui.activities;


import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.ui.fragments.SharedBaseFragmentActivity;
import com.nilportugues.simplewebapi.users.ui.adapters.FragmentAdapter;

import butterknife.BindView;

public class Activity3 extends SharedBaseFragmentActivity{

    @BindView(R.id.viewPager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadViewPager();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.users_activity3;
    }

    private void loadViewPager() {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        if (viewPager != null) {
            viewPager.setAdapter(adapter);
        }
    }

}
