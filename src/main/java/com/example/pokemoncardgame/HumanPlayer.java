package com.example.pokemoncardgame;

import java.util.List;
import java.util.Random;

public class HumanPlayer extends Player {

    List<Card> cardList;

    HumanPlayer() {
        super();
    }

    HumanPlayer(int id, String name, long score) {
        super(id, name, score);
    }

    HumanPlayer(int id, String name, long score, List<Card> list) {
        super(id, name, score);
        this.cardList = list;
    }

    @Override
    public Card selectCard() {
        Random rand = new Random();
        return cardList.get(rand.nextInt(cardList.size()));
    }

    public void drawCard(Card newCard) {
        this.cardList.add(newCard);
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

    public void showHand() {
        System.out.println("Your cards: ");
        for (int i=0; i<this.cardList.size(); i++) {
            System.out.println((i+1) + " " + this.cardList.get(i).getPokemonName() + " " + this.cardList.get(i).getAttackPoint());
        }
    }


}
