package com.nilportugues.simplewebapi.users.ui.usertabsicons;


import com.nilportugues.simplewebapi.shared.ui.PresenterContract;
import com.nilportugues.simplewebapi.shared.ui.ViewContract;

import java.util.List;

public interface TabsWithIconsContract {

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
