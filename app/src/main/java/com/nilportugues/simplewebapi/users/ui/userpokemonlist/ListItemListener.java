package com.nilportugues.simplewebapi.users.ui.userpokemonlist;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.users.ui.userpokemon.UserPokemonActivity;


public class ListItemListener implements AdapterView.OnItemClickListener
{
    UserPokemonListActivity activity;

    public ListItemListener(UserPokemonListActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        ViewGroup viewGroup = (ViewGroup) view;

        String pokemonNumber = getPokemonNumberFromView(viewGroup);
        String pokemonName = getPokemonNameFromView(viewGroup);

        loadUserPokemonActivity(pokemonNumber, pokemonName);
    }

    private String getPokemonNumberFromView(ViewGroup view) {
        String pokemonNumber;

        TextView textView = (TextView) view.findViewById(R.id.pokemonApiNumber);
        pokemonNumber = textView.getText().toString();

        return pokemonNumber;
    }

    private String getPokemonNameFromView(ViewGroup view) {
        String pokemonName;
        TextView textView = (TextView) view.findViewById(R.id.pokemonListName);
        pokemonName = textView.getText().toString();

        return pokemonName;
    }

    private void loadUserPokemonActivity(String pokemonNumber, String pokemonName) {
        Intent intent = new Intent(activity, UserPokemonActivity.class);

        intent.putExtra(UserPokemonActivity.POKEMON_NUMBER, pokemonNumber);
        intent.putExtra(UserPokemonActivity.POKEMON_NAME, pokemonName);

        activity.startActivityForResult(intent, UserPokemonActivity.REQUEST_CODE);
    }
}