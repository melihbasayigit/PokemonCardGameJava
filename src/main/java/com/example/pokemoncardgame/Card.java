package com.example.pokemoncardgame;

import java.util.List;
import java.util.Random;

public abstract class Card {
    private int pokemonID;
    private String pokemonName;
    private String pokemonType;

    Card() {

    }

    Card(String name, String type) {
        this.pokemonType = type;
        this.pokemonName = name;
    }

    Card(int id, String name, String type) {
        this.pokemonID = id;
        this.pokemonName = name;
        this.pokemonType = type;
    }

    public int getAttackPoint() {
        return 0;
    }


    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }

    public void setPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
    }

    public int getPokemonID() {
        return pokemonID;
    }

    public void showAllStats() {
        System.out.println(this.pokemonID + " " + this.pokemonName + " " + this.pokemonType + " " + getAttackPoint());
    }

}
