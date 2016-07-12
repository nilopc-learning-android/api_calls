package com.nilportugues.simplewebapi.users.ui.activities.fragment;


import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.ui.fragments.SharedBaseFragmentActivity;
import com.nilportugues.simplewebapi.users.ui.adapters.fragment.FragmentAdapter;

import butterknife.BindView;

public class FragmentActivity extends SharedBaseFragmentActivity{

    @BindView(R.id.activity3_view_pager) ViewPager viewPager;

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