package com.nilportugues.simplewebapi.users.ui.userpokemonlist;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.shared.ui.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

public class UserPokemonListActivity extends BaseActivity
{
    @BindView(R.id.userPokemonListView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<PokemonEntry> pokemonList = new ArrayList<>();
        pokemonList.add(new PokemonEntry(1, "Bulbasaur", "Grass", "Poison"));
        pokemonList.add(new PokemonEntry(2, "Ivysaur", "Grass", "Poison"));
        pokemonList.add(new PokemonEntry(3, "Venusaur", "Grass", "Poison"));
        pokemonList.add(new PokemonEntry(4, "Charmander", "Fire", ""));
        pokemonList.add(new PokemonEntry(5, "Charmaleon", "Fire", ""));
        pokemonList.add(new PokemonEntry(6, "Charizard", "Fire", "Flying"));
        pokemonList.add(new PokemonEntry(7, "Squirtle", "Water", ""));
        pokemonList.add(new PokemonEntry(8, "Wartortle", "Water", ""));
        pokemonList.add(new PokemonEntry(9, "Blastoise", "Water", ""));
        pokemonList.add(new PokemonEntry(10, "Caterpie", "Bug", ""));
        pokemonList.add(new PokemonEntry(11, "Metapod", "Bug", ""));
        pokemonList.add(new PokemonEntry(12, "Butterfree", "Bug", "Flying"));

        UserPokemonListAdapter adapter = new UserPokemonListAdapter(
                getApplicationContext(),
                R.layout.user_pokemon_list_row,
                pokemonList
        );


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemListListener());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_pokemon_list;
    }

    class ItemListListener implements AdapterView.OnItemClickListener
    {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            ViewGroup viewGroup = (ViewGroup) view;
            TextView textView = (TextView) viewGroup.findViewById(R.id.pokemonListNumber);

            Toast.makeText(
                    UserPokemonListActivity.this,
                    "Clicked " + textView.getText().toString(),
                    Toast.LENGTH_SHORT
            ).show();

        }
    }
}


