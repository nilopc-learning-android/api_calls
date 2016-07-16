package com.nilportugues.simplewebapi.users.ui.usertabsscrollable;

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


public class TabsScrollableActivity extends BaseFragmentActivity {

    @Inject UserPokemonList interactor;
    @BindView(R.id.tabs3_view_pager) ViewPager viewPager;
    @BindView(R.id.tabs3_layout) TabLayout tabLayout;
    @BindView(R.id.tabs3_toolbar) Toolbar toolbar;
    @BindView(R.id.tabs3_progressbar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
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
        TabsScrollableView view = new TabsScrollableView(
                getSupportFragmentManager(),
                viewPager,
                tabLayout,
                toolbar,
                progressBar
        );

        TabsScrollablePresenter presenter = new TabsScrollablePresenter(interactor, view);
        presenter.subscribe();
    }
}
