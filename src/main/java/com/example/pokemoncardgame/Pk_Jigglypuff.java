package com.example.pokemoncardgame;

public class Pk_Jigglypuff extends Card{

    private final int attackPoint;
    private boolean isUsed;

    Pk_Jigglypuff() {
        super(9,"Jigglypuff", "Ses");
        this.attackPoint = 70;
        this.isUsed =false;
    }

    @Override
    public int getAttackPoint() {
        return attackPoint;
    }

    public void Used() {
        this.setUsed(true);
    }

    public boolean getIsUsed() {
        return this.isUsed;
    }

    @Override
    public int getPokemonID() {
        return super.getPokemonID();
    }

    @Override
    public String getPokemonName() {
        return super.getPokemonName();
    }

    @Override
    public String getPokemonType() {
        return super.getPokemonType();
    }

    @Override
    public void setPokemonType(String pokemonType) {
        super.setPokemonType(pokemonType);
    }

    @Override
    public void setPokemonID(int pokemonID) {
        super.setPokemonID(pokemonID);
    }

    @Override
    public void setPokemonName(String pokemonName) {
        super.setPokemonName(pokemonName);
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}

