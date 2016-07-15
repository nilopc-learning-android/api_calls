package com.nilportugues.simplewebapi.users.ui.userpagerlist;


import com.nilportugues.simplewebapi.shared.ui.PresenterContract;
import com.nilportugues.simplewebapi.shared.ui.ViewContract;
import com.nilportugues.simplewebapi.users.repository.model.User;

import java.util.List;

public interface UserListContract {

    interface Presenter extends PresenterContract
    {
        void showLoadingIndicator(boolean active);

        void setUserList(List<User> userList);

        void showResults(boolean complete);
    }

    interface View extends ViewContract<Presenter>{

        void showLoading();

        void setList(List<User> userList);

        void hideLoading();

        void showList();

        void showErrorList();
    }
}
