package com.nilportugues.simplewebapi.users.ui.activities.tabs;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.ui.fragments.SharedBaseFragmentActivity;
import com.nilportugues.simplewebapi.users.ui.adapters.tabs.TabsWithTextAdapter;
import com.nilportugues.simplewebapi.users.ui.fragments.FragmentOne;
import com.nilportugues.simplewebapi.users.ui.fragments.FragmentThree;
import com.nilportugues.simplewebapi.users.ui.fragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class TabsWithTextActivity extends SharedBaseFragmentActivity {

    protected List<Fragment> fragmentList = new ArrayList<>();
    protected List<String> titleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        buildTabs();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.users_tabs_text;
    }

    protected void buildTabs() {
        buildTabsTitle();
        buildTabsContent();

        ViewPager viewPager = (ViewPager) findViewById(R.id.tabs_text_view_pager);

        TabsWithTextAdapter adapter = new TabsWithTextAdapter(getSupportFragmentManager(), fragmentList, titleList);
        if (viewPager != null) {
            viewPager.setAdapter(adapter);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_layout);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    private void buildTabsTitle() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("Text Tabs");
        }
    }

    private void buildTabsContent() {
        this.buildFragment(new FragmentOne(), "ONE");
        this.buildFragment(new FragmentTwo(), "TWO");
        this.buildFragment(new FragmentThree(), "THREE");
    }

    private void buildFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }
}
