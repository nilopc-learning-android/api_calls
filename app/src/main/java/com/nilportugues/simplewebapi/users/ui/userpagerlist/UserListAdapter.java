package com.nilportugues.simplewebapi.users.ui.userpagerlist;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.users.repository.model.User;

import java.util.List;

public class UserListAdapter extends PagerAdapter {

    private List<User> userList;
    private LayoutInflater inflater;

    public UserListAdapter(Context context, List<User> userList) {

        this.userList = userList;
        this.inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return userList.toArray().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = inflater.inflate(R.layout.users_activity2_viewpager_item, container, false);

        if (!userList.isEmpty()) {
            User user = userList.get(position);
            setModelDataToView(user, itemView);
            container.addView(itemView);
        }

        return itemView;
    }

    private void setModelDataToView(User user, View itemView) {
        TextView userIdView = (TextView) itemView.findViewById(R.id.userId);
        TextView emailView = (TextView) itemView.findViewById(R.id.email);
        TextView nameView = (TextView) itemView.findViewById(R.id.name);
        TextView userNameTextView = (TextView) itemView.findViewById(R.id.userName);

        userIdView.setText(user.getId().toString());
        emailView.setText(user.getEmail().toString());
        nameView.setText(user.getName().toString());
        userNameTextView.setText(user.getUsername().toString());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
    }
}
