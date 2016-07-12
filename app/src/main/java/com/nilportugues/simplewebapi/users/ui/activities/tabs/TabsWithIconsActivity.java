package com.nilportugues.simplewebapi.users.ui.activities.tabs;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.ui.fragments.SharedBaseFragmentActivity;
import com.nilportugues.simplewebapi.users.ui.adapters.tabs.TabsWithIconsAdapter;
import com.nilportugues.simplewebapi.users.ui.fragments.FragmentOne;
import com.nilportugues.simplewebapi.users.ui.fragments.FragmentThree;
import com.nilportugues.simplewebapi.users.ui.fragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TabsWithIconsActivity extends SharedBaseFragmentActivity {

    @BindView(R.id.tabs2_view_pager) ViewPager viewPager;
    @BindView(R.id.tabs2_layout) TabLayout tabLayout;

    protected List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeActionBar();
        buildTabs();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.users_tabs_icons;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.tabs2_toolbar);
        if (toolbar != null) {
            toolbar.setTitle("Icon Tabs");
        }
    }

    protected void buildTabsContent() {
        this.buildFragment(new FragmentOne());
        this.buildFragment(new FragmentTwo());
        this.buildFragment(new FragmentThree());
    }

    protected void buildFragment(Fragment fragment) {
        fragmentList.add(fragment);
    }


    protected void buildView() {
        TabsWithIconsAdapter adapter = new TabsWithIconsAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        setTabIcons();
    }

    protected void setTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.background_splash);
        tabLayout.getTabAt(1).setIcon(R.drawable.background_splash);
        tabLayout.getTabAt(2).setIcon(R.drawable.background_splash);

    }
}