package com.nilportugues.simplewebapi.users.ui.usetabstext;


import com.nilportugues.simplewebapi.shared.ui.PresenterContract;
import com.nilportugues.simplewebapi.shared.ui.ViewContract;

import java.util.List;

public interface TabsWithTextContract {

    interface Presenter extends PresenterContract {
        void showLoading(boolean active);

        void setList(List<String> userPokemon);

        void showTabs(boolean active);
    }

    interface View extends ViewContract<Presenter> {
        void showLoading();

        void hideLoading();

        void setList(List<String> userPokemon);

        void showTabs();

        void showErroredTabs();
    }
}
