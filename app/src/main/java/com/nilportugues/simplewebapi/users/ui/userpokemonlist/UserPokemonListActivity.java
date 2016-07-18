package com.nilportugues.simplewebapi.users.ui.userpokemonlist;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon(1, "Bulbasaur", "Grass", "Poison"));
        pokemonList.add(new Pokemon(2, "Ivysaur", "Grass", "Poison"));
        pokemonList.add(new Pokemon(3, "Venusaur", "Grass", "Poison"));
        pokemonList.add(new Pokemon(4, "Charmander", "Fire", ""));
        pokemonList.add(new Pokemon(5, "Charmaleon", "Fire", ""));
        pokemonList.add(new Pokemon(6, "Charizard", "Fire", "Flying"));
        pokemonList.add(new Pokemon(7, "Squirtle", "Water", ""));

        UserPokemonListAdapter adapter = new UserPokemonListAdapter(
                getApplicationContext(),
                R.layout.user_pokemon_list_row,
                pokemonList
        );


        listView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_pokemon_list;
    }
}

class Pokemon
{
    private Integer PokemonNumber;
    private String PokemonName;
    private String TypeOne;
    private String TypeTwo;

    public Pokemon(Integer pokemonNumber, String pokemonName, String typeOne, String typeTwo) {
        PokemonNumber = pokemonNumber;
        PokemonName = pokemonName;
        TypeOne = typeOne;
        TypeTwo = typeTwo;
    }

    public Integer getPokemonNumber() {
        return PokemonNumber;
    }

    public String getPokemonName() {
        return PokemonName;
    }

    public String getTypeOne() {
        return TypeOne;
    }

    public String getTypeTwo() {
        return TypeTwo;
    }
}


class UserPokemonListRowView
{
    ImageView artwork;
    TextView name;
    TextView typeOne;
    TextView typeTwo;

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

class UserPokemonListAdapter extends ArrayAdapter<Pokemon> {

    private ArrayList<Pokemon> pokemonList;

    public UserPokemonListAdapter(
            Context context,
            int textViewResourceId,
            ArrayList<Pokemon> PokemonListItemList
    ) {
        super(context, textViewResourceId, PokemonListItemList);
        this.pokemonList = new ArrayList<>();
        this.pokemonList.addAll(PokemonListItemList);
    }


    public void add(Pokemon PokemonListItem){
        Log.v("AddView", PokemonListItem.getPokemonName());
        this.pokemonList.add(PokemonListItem);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        UserPokemonListRowView holder = null;
        Log.v("ConvertView", String.valueOf(position));
        if (convertView == null) {

            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.user_pokemon_list_row, null);

            holder = new UserPokemonListRowView();
            holder.artwork = (ImageView) convertView.findViewById(R.id.pokemonListArtwork);
            holder.name = (TextView) convertView.findViewById(R.id.pokemonListName);
            holder.typeOne = (TextView) convertView.findViewById(R.id.pokemonListTypeOne);
            holder.typeTwo = (TextView) convertView.findViewById(R.id.pokemonListTypeTwo);

            convertView.setTag(holder);

        } else {
            holder = (UserPokemonListRowView) convertView.getTag();
        }

        Pokemon pokemon = this.pokemonList.get(position);

        int resource = getContext().getResources().getIdentifier(
                "p" + String.format("%03d", pokemon.getPokemonNumber()),
                "drawable",
                getContext().getPackageName()
        );

        holder.artwork.setImageResource(resource);
        holder.name.setText(pokemon.getPokemonName());
        holder.typeOne.setText(pokemon.getTypeOne());
        holder.typeTwo.setText(pokemon.getTypeTwo());

        return convertView;

    }

}