package com.nilportugues.simplewebapi.users.ui.userpokemonlist;


import android.widget.ImageView;
import android.widget.TextView;

public class ListItemView
{
    private ImageView artwork;
    private TextView name;
    private TextView typeOne;
    private TextView typeTwo;
    private TextView listNumber;
    private TextView apiNumber;

    public ListItemView(
            ImageView artwork,
            TextView name,
            TextView typeOne,
            TextView typeTwo,
            TextView listNumber,
            TextView apiNumber
    ) {
        this.artwork = artwork;
        this.name = name;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
        this.listNumber = listNumber;
        this.apiNumber = apiNumber;
    }

    public ImageView getArtwork() {
        return artwork;
    }

    public TextView getName() {
        return name;
    }
    public TextView getListNumber() {
        return listNumber;
    }

    public TextView getInternalNumber() {
        return apiNumber;
    }

    public TextView getTypeOne() {
        return typeOne;
    }

    public TextView getTypeTwo() {
        return typeTwo;
    }
}