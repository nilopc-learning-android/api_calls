package com.nilportugues.simplewebapi.users.ui.userpokemonlist;

public class ListItemPresenter
{
    private Integer pokemonNumber;
    private String pokemonName;
    private String typeOne;
    private String typeTwo;

    public ListItemPresenter(Integer pokemonNumber, String pokemonName, String typeOne, String typeTwo) {
        this.pokemonNumber = pokemonNumber;
        this.pokemonName = pokemonName;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
    }

    public String getPokemonNumber() {
        return String.format("%03d", pokemonNumber);
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getTypeOne() {
        return typeOne;
    }

    public String getTypeTwo() {
        return typeTwo;
    }
}

