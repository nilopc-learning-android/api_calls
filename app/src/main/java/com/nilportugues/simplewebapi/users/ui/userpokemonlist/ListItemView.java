package com.nilportugues.simplewebapi.users.ui.userpokemonlist;


import android.widget.ImageView;
import android.widget.TextView;

public class ListItemView
{
    private ImageView artwork;
    private TextView name;
    private TextView typeOne;
    private TextView typeTwo;
    private TextView number;

    public ListItemView(
            ImageView artwork,
            TextView name,
            TextView typeOne,
            TextView typeTwo,
            TextView number
    ) {
        this.artwork = artwork;
        this.name = name;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
        this.number = number;
    }

    public ImageView getArtwork() {
        return artwork;
    }

    public TextView getName() {
        return name;
    }
    public TextView getNumber() {
        return number;
    }

    public TextView getTypeOne() {
        return typeOne;
    }

    public TextView getTypeTwo() {
        return typeTwo;
    }
}