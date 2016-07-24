package com.nilportugues.simplewebapi.users.ui.userpokemon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nilportugues.simplewebapi.R;
import com.nilportugues.simplewebapi.users.ui.BaseActivity;

import butterknife.BindView;


public class UserPokemonActivity extends BaseActivity {

    public static final int REQUEST_CODE = 1000;
    public static final String POKEMON_NUMBER = "pokemonNumber";
    public static final String POKEMON_NAME = "pokemonName";

    @BindView(R.id.userPokemonNameTitle) TextView title;
    @BindView(R.id.userPokemonImage) ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String pokemonNumber = intent.getStringExtra(POKEMON_NUMBER);
        String pokemonName = intent.getStringExtra(POKEMON_NAME);

        buildView(pokemonNumber, pokemonName);
    }

    private void buildView(String pokemonNumber, String pokemonName) {
        title.setText("#"+pokemonNumber+" "+pokemonName);
        image.setImageResource(getResources().getIdentifier(
            "p" + pokemonNumber,
            "drawable",
            getApplicationContext().getPackageName()
        ));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_pokemon;
    }
}
