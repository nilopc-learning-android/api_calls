package com.nilportugues.simplewebapi.users.ui.userlist;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.nilportugues.simplewebapi.R;

import java.util.ArrayList;
import java.util.List;

//Array of <> --> ArrayAdapter --> ListView

public class UserListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        /*
        List<String> userList = getItemList();
        ListAdapter adapter = createListAdapter(userList);

        ListView list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(adapter);
        */
    }

    @NonNull
    private ArrayAdapter<String> createListAdapter(List<String> userList) {
        return new ArrayAdapter<>(this, R.layout.user_list_row, userList);
    }

    @NonNull
    private List<String> getItemList() {
        List<String> userList = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            userList.add( "User "+i);
        }
        return userList;
    }

}
