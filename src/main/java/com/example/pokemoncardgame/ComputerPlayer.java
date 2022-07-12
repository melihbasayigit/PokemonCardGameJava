package com.example.pokemoncardgame;

import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {

    List<Card> cardList;

    ComputerPlayer() {
        super();
    }

    ComputerPlayer(int id, String name, long score) {
        super(id,name,score);
    }

    @Override
    public void drawCard(Card n) {
        this.cardList.add(n);
    }

    @Override
    public void destroyCard(String pokeName) {
        for (int i=0; i<this.cardList.size(); i++) {
            if(this.cardList.get(i).getPokemonName() == pokeName) {
                this.cardList.remove(i);
                break;
            }

        }
    }

    ComputerPlayer(int id, String name, long score, List<Card> list) {
        super(id,name,score);
        this.cardList = list;
    }

    public Card playCard(int cardID) {
        for (int i=0; i<this.cardList.size(); i++) {
            if(cardList.get(i).getPokemonID() == cardID) {
                Card choosenCard = cardList.get(i);
                cardList.remove(i);
                return choosenCard;
            }
        }
        return null;
    }

    public void showHand() {
        for (int i=0; i<this.cardList.size(); i++) {
            System.out.println((i+1) + " " + this.cardList.get(i).getPokemonName() + " " + this.cardList.get(i).
                    getAttackPoint());
        }
    }


}
