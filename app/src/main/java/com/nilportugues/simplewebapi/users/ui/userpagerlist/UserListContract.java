package com.nilportugues.simplewebapi.users.ui.userpagerlist;


import com.nilportugues.simplewebapi.shared.ui.PresenterContract;
import com.nilportugues.simplewebapi.shared.ui.ViewContract;
import com.nilportugues.simplewebapi.users.repository.model.User;

import java.util.List;

public interface UserListContract {

    interface Presenter extends PresenterContract
    {
        void showLoading(boolean active);

        void setUserList(List<User> userList);

        void showList(boolean complete);
    }

    interface View extends ViewContract<Presenter>{

        void showLoading();

        void hideLoading();

        void setUserList(List<User> userList);

        void showList();

        void showErrorList();
    }
}
