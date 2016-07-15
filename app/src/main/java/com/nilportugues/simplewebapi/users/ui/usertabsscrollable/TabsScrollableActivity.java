package com.nilportugues.simplewebapi.users.ui.usertabsscrollable;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.ui.BaseFragmentActivity;
import com.nilportugues.simplewebapi.users.ui.userpager.FragmentOne;
import com.nilportugues.simplewebapi.users.ui.userpager.FragmentThree;
import com.nilportugues.simplewebapi.users.ui.userpager.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class TabsScrollableActivity extends BaseFragmentActivity {

    @BindView(R.id.tabs3_view_pager) ViewPager viewPager;
    @BindView(R.id.tabs3_layout) TabLayout tabLayout;
    @BindView(R.id.tabs3_toolbar) Toolbar toolbar;

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
        return R.layout.users_tabs_scrollable;
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
        toolbar.setTitle("Scroll Tabs");
    }

    protected void buildTabsContent() {
        this.buildFragment(new FragmentOne(), "ONE");
        this.buildFragment(new FragmentTwo(), "TWO");
        this.buildFragment(new FragmentThree(), "THREE");
        this.buildFragment(new FragmentThree(), "FOUR");
        this.buildFragment(new FragmentThree(), "FIVE");
        this.buildFragment(new FragmentThree(), "SIX");
        this.buildFragment(new FragmentThree(), "SEVEN");
    }

    protected void buildFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }


    protected void buildView() {
        TabsScrollAdapter adapter = new TabsScrollAdapter(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
