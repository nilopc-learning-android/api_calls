package com.nilportugues.simplewebapi.users.ui.usertabstext;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.users.interactors.UserPokemonList;
import com.nilportugues.simplewebapi.users.ui.BaseFragmentActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class TabsWithTextActivity extends BaseFragmentActivity {

    @Inject UserPokemonList interactor;
    @BindView(R.id.tabs1_view_pager) ViewPager viewPager;
    @BindView(R.id.tabs1_layout) TabLayout tabLayout;
    @BindView(R.id.tabs1_toolbar) Toolbar toolbar;
    @BindView(R.id.tabs1_progressbar) ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
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
        TabsWithTextView view = new TabsWithTextView(
                getSupportFragmentManager(),
                viewPager,
                tabLayout,
                toolbar,
                progressBar
        );

        TabsWithTextPresenter presenter = new TabsWithTextPresenter(interactor, view);
        presenter.subscribe();
    }
}
