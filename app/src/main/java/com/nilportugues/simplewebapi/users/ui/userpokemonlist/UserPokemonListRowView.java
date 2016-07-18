package com.nilportugues.simplewebapi.users.ui.userpokemonlist;


import android.widget.ImageView;
import android.widget.TextView;

public class UserPokemonListRowView
{
    private ImageView artwork;
    private TextView name;
    private TextView typeOne;
    private TextView typeTwo;

    public UserPokemonListRowView(ImageView artwork, TextView name, TextView typeOne, TextView typeTwo) {
        this.artwork = artwork;
        this.name = name;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
    }

    public ImageView getArtwork() {
        return artwork;
    }

    public TextView getName() {
        return name;
    }

    public TextView getTypeOne() {
        return typeOne;
    }

    public TextView getTypeTwo() {
        return typeTwo;
    }
}