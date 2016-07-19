package com.nilportugues.simplewebapi.users.ui.userpokemonlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;

import java.util.ArrayList;

public class UserPokemonListAdapter extends ArrayAdapter<ListItemPresenter> {

    private ArrayList<ListItemPresenter> pokemonList;

    public UserPokemonListAdapter(
            Context context,
            int textViewResourceId,
            ArrayList<ListItemPresenter> PokemonListItemList
    ) {
        super(context, textViewResourceId, PokemonListItemList);
        this.pokemonList = new ArrayList<>();
        this.pokemonList.addAll(PokemonListItemList);
    }


    public void add(ListItemPresenter PokemonListItem) {
        Log.v("AddView", PokemonListItem.getPokemonName());
        this.pokemonList.add(PokemonListItem);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListItemView rowView;

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.user_pokemon_list_row, null);
            rowView = createRowView(convertView);
            convertView.setTag(rowView);
        } else {
            rowView = (ListItemView) convertView.getTag();
        }

        populateRowView(rowView, this.pokemonList.get(position));

        return convertView;

    }

    private ListItemView createRowView(View convertView) {
        return new ListItemView(
                (ImageView) convertView.findViewById(R.id.pokemonListArtwork),
                (TextView) convertView.findViewById(R.id.pokemonListName),
                (TextView) convertView.findViewById(R.id.pokemonListTypeOne),
                (TextView) convertView.findViewById(R.id.pokemonListTypeTwo),
                (TextView) convertView.findViewById(R.id.pokemonListNumber)
        );
    }

    private void populateRowView(ListItemView rowView, ListItemPresenter pokemon) {

        int resource = getResourceFromPokemon(pokemon);


        rowView.getArtwork().setImageResource(resource);
        rowView.getName().setText(pokemon.getPokemonName());
        rowView.getTypeOne().setText(pokemon.getTypeOne());
        rowView.getTypeTwo().setText(pokemon.getTypeTwo());
        rowView.getNumber().setText(String.format("#%03d", pokemon.getPokemonNumber()));
    }

    private int getResourceFromPokemon(ListItemPresenter pokemon) {
        return getContext().getResources().getIdentifier(
            "p" + String.format("%03d", pokemon.getPokemonNumber()),
            "drawable",
            getContext().getPackageName()
        );
    }

}