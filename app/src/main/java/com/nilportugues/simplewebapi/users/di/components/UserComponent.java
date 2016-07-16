package com.nilportugues.simplewebapi.users.di.components;

import com.nilportugues.simplewebapi.users.di.modules.ApiModule;
import com.nilportugues.simplewebapi.users.di.modules.DomainServiceModule;
import com.nilportugues.simplewebapi.users.di.modules.ApplicationServiceModule;
import com.nilportugues.simplewebapi.users.di.modules.RepositoryModule;
import com.nilportugues.simplewebapi.users.ui.userpagerlist.UserListActivity;
import com.nilportugues.simplewebapi.users.ui.usersearch.UserSearchActivity;
import com.nilportugues.simplewebapi.users.ui.usetabstext.TabsWithTextActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApiModule.class,
                DomainServiceModule.class,
                ApplicationServiceModule.class,
                RepositoryModule.class
        }
)
public interface UserComponent {
    void inject(UserListActivity activity);
    void inject(UserSearchActivity activity);
    void inject(TabsWithTextActivity activity);
}
