package com.nilportugues.simplewebapi.users.ui.usetabstext;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.nilportugues.simplewebapi.users.ui.userpager.FragmentOne;
import com.nilportugues.simplewebapi.users.ui.userpager.FragmentThree;
import com.nilportugues.simplewebapi.users.ui.userpager.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class TabsWithTextView implements TabsWithTextContract.View{

    private FragmentManager mFragmentManager;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private ProgressBar mProgressBar;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private TabsWithTextContract.Presenter mPresenter;
    private List<String> userPokemon;

    public TabsWithTextView(FragmentManager fragmentManager, ViewPager viewPager, TabLayout tabLayout, Toolbar toolbar, ProgressBar progressBar) {
        mFragmentManager = fragmentManager;
        mViewPager = viewPager;
        mTabLayout = tabLayout;
        mToolbar = toolbar;
        mProgressBar = progressBar;
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(android.view.View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(android.view.View.GONE);
    }

    @Override
    public void setList(List<String> userPokemon) {
        this.userPokemon = userPokemon;
    }

    @Override
    public void showTabs() {
        buildTabsTitle();
        buildTabsContent();
        buildView();
    }

    @Override
    public void showErroredTabs() {
        mToolbar.setTitle("Could not load tabs");
        buildView();
    }

    @Override
    public void setPresenter(TabsWithTextContract.Presenter presenter) {
        mPresenter = presenter;
    }

    protected void buildTabsTitle() {
        mToolbar.setTitle("Text Tabs");
    }

    protected void buildTabsContent() {
        this.buildFragment(new FragmentOne(), this.userPokemon.get(0));
        this.buildFragment(new FragmentTwo(), this.userPokemon.get(1));
        this.buildFragment(new FragmentThree(), this.userPokemon.get(2));
    }

    protected void buildFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }

    protected void buildView() {
        TabsWithTextAdapter adapter = new TabsWithTextAdapter(mFragmentManager, fragmentList, titleList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}