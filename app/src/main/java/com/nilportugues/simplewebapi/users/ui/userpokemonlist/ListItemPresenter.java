package com.nilportugues.simplewebapi.users.ui.userpokemonlist;

public class ListItemPresenter
{
    private Integer PokemonNumber;
    private String PokemonName;
    private String TypeOne;
    private String TypeTwo;

    public ListItemPresenter(Integer pokemonNumber, String pokemonName, String typeOne, String typeTwo) {
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

