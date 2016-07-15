package com.nilportugues.simplewebapi.users.ui.usertabscustomview;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.ui.SharedBaseFragmentActivity;
import com.nilportugues.simplewebapi.users.ui.userpager.FragmentOne;
import com.nilportugues.simplewebapi.users.ui.userpager.FragmentThree;
import com.nilportugues.simplewebapi.users.ui.userpager.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TabsWithCustomViewsActivity extends SharedBaseFragmentActivity {

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
        this.buildFragment(new FragmentOne(), "ONE");
        this.buildFragment(new FragmentTwo(), "TWO");
        this.buildFragment(new FragmentThree(), "THREE");
    }

    protected void buildFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }


    protected void buildView() {
        TabsCustomAdapter adapter = new TabsCustomAdapter(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        buildCustomTabView("Bulbasaur", "Grass/Poison", 0);
        buildCustomTabView("Charmander", "Fire", 1);
        buildCustomTabView("Squirtle", "Water", 2);
    }

    protected void buildCustomTabView(String title, String subtitle, int position) {

        LinearLayout tabView = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.user_tab_item, null);

        TextView titleView = (TextView) tabView.findViewById(R.id.tabTextTitle);
        titleView.setText(title);

        TextView subtitleView = (TextView) tabView.findViewById(R.id.tabTextSubTitle);
        subtitleView.setText(subtitle);

        TabLayout.Tab tab = tabLayout.getTabAt(position);
        if (tab != null) {
            tab.setCustomView(tabView);
        }
    }
}
