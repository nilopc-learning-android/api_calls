package com.nilportugues.simplewebapi.users.ui.usertabsscrollable;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.nilportugues.simplewebapi.users.ui.fragments.FragmentOne;
import com.nilportugues.simplewebapi.users.ui.fragments.FragmentThree;
import com.nilportugues.simplewebapi.users.ui.fragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class TabsScrollableView implements TabsScrollableContract.View{

    private FragmentManager mFragmentManager;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private ProgressBar mProgressBar;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private TabsScrollableContract.Presenter mPresenter;
    private List<String> userPokemon;

    public TabsScrollableView(FragmentManager fragmentManager, ViewPager viewPager, TabLayout tabLayout, Toolbar toolbar, ProgressBar progressBar) {
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
    public void setPresenter(TabsScrollableContract.Presenter presenter) {
        mPresenter = presenter;
    }

    protected void buildTabsTitle() {
        mToolbar.setTitle("Scrollable Tabs");
    }

    protected void buildTabsContent() {
        this.buildFragment(new FragmentOne(), this.userPokemon.get(0));
        this.buildFragment(new FragmentTwo(), this.userPokemon.get(1));
        this.buildFragment(new FragmentThree(), this.userPokemon.get(2));
        this.buildFragment(new FragmentThree(), this.userPokemon.get(3));
        this.buildFragment(new FragmentThree(), this.userPokemon.get(4));
        this.buildFragment(new FragmentThree(), this.userPokemon.get(5));
        this.buildFragment(new FragmentThree(), this.userPokemon.get(6));
    }

    protected void buildFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }

    protected void buildView() {
        TabsScrollAdapter adapter = new TabsScrollAdapter(mFragmentManager, fragmentList, titleList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}