package com.nilportugues.simplewebapi.users.ui.userpokemonlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.nilportugues.simplewebapi.R;


public class ListItemListener implements AdapterView.OnItemClickListener
{
    UserPokemonListActivity activity;

    public ListItemListener(UserPokemonListActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ViewGroup viewGroup = (ViewGroup) view;
        TextView textView = (TextView) viewGroup.findViewById(R.id.pokemonListNumber);

        Toast.makeText(this.activity, "Clicked " + textView.getText().toString(), Toast.LENGTH_LONG).show();

    }
}