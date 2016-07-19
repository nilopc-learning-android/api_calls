package com.nilportugues.simplewebapi.users.ui.userpokemonlist;

import android.os.Bundle;
import android.widget.ListView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.ui.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

public class UserPokemonListActivity extends BaseActivity
{
    @BindView(R.id.userPokemonListView) ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<ListItemPresenter> pokemonList = new ArrayList<>();
        pokemonList.add(new ListItemPresenter(1, "Bulbasaur", "Grass", "Poison"));
        pokemonList.add(new ListItemPresenter(2, "Ivysaur", "Grass", "Poison"));
        pokemonList.add(new ListItemPresenter(3, "Venusaur", "Grass", "Poison"));
        pokemonList.add(new ListItemPresenter(4, "Charmander", "Fire", ""));
        pokemonList.add(new ListItemPresenter(5, "Charmaleon", "Fire", ""));
        pokemonList.add(new ListItemPresenter(6, "Charizard", "Fire", "Flying"));
        pokemonList.add(new ListItemPresenter(7, "Squirtle", "Water", ""));
        pokemonList.add(new ListItemPresenter(8, "Wartortle", "Water", ""));
        pokemonList.add(new ListItemPresenter(9, "Blastoise", "Water", ""));
        pokemonList.add(new ListItemPresenter(10, "Caterpie", "Bug", ""));
        pokemonList.add(new ListItemPresenter(11, "Metapod", "Bug", ""));
        pokemonList.add(new ListItemPresenter(12, "Butterfree", "Bug", "Flying"));

        buildList(pokemonList);
    }

    protected void buildList(ArrayList<ListItemPresenter> pokemonList) {
        UserPokemonListAdapter adapter = new UserPokemonListAdapter(getApplicationContext(), getRowViewId(), pokemonList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ListItemListener(this));
    }

    protected int getRowViewId() {
        return R.layout.user_pokemon_list_row;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_pokemon_list;
    }
}


