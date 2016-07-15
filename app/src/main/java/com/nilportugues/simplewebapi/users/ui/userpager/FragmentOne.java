package com.nilportugues.simplewebapi.users.ui.userpager;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nilportugues.simplewebapi.R;


public class FragmentOne extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.users_activity3_fragment_one, container, false);

        setImageView(view);

        return view;
    }

    private void setImageView(View view) {
        ImageView pokemonView = (ImageView) view.findViewById(R.id.pokemonImageView);
        pokemonView.setBackgroundResource(R.drawable.bulbasaur);

        AnimationDrawable frameAnimation = (AnimationDrawable) pokemonView.getBackground();
        frameAnimation.start();
    }
}
