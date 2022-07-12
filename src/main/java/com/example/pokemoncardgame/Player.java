package com.example.pokemoncardgame;

import java.util.List;
import java.util.Random;

public abstract class Player {
    private int playerID;
    private String playerName;
    private long score;


    Player() {

    }

    Player(int id, String name, long score) {
        this.playerID = id;
        this.playerName = name;
        this.score = score;
    }

    public Card selectCard() {
        return null;
    }


    public abstract void drawCard(Card n);

    public abstract void destroyCard(String pokeName);


    public int getPlayerID() {
        return playerID;
    }

    public long getScore() {
        return score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
