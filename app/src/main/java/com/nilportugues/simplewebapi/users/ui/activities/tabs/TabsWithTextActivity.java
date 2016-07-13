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

import butterknife.BindView;

public class TabsWithTextActivity extends SharedBaseFragmentActivity {

    @BindView(R.id.tabs1_view_pager) ViewPager viewPager;
    @BindView(R.id.tabs1_layout) TabLayout tabLayout;
    @BindView(R.id.tabs1_toolbar) Toolbar toolbar;

    protected List<Fragment> fragmentList = new ArrayList<>();
    protected List<String> titleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeActionBar();
        buildTabs();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.users_tabs_text;
    }

    protected void removeActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    protected void buildTabs() {
        buildTabsTitle();
        buildTabsContent();
        buildView();
    }

    protected void buildTabsTitle() {
        toolbar.setTitle("Text Tabs");
    }

    protected void buildTabsContent() {
        this.buildFragment(new FragmentOne(), "Bulbasaur");
        this.buildFragment(new FragmentTwo(), "Charmander");
        this.buildFragment(new FragmentThree(), "Squirtle");
    }

    protected void buildFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }


    protected void buildView() {
        TabsWithTextAdapter adapter = new TabsWithTextAdapter(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
