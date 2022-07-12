package com.example.pokemoncardgame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.ImageCursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SceneGaming {

    @FXML
    private ImageView humImageView;
    @FXML
    private ImageView comImageView;
    @FXML
    private Label scoreLabelComputer;
    @FXML
    private Label scoreLabelHuman;
    @FXML
    private Label deckSizeLabel;
    @FXML
    private Button startButton;
    @FXML
    private Button slot1;
    @FXML
    private Button slot2;
    @FXML
    private Button slot3;
    @FXML
    private Button slot4;
    @FXML
    private Button slot5;
    @FXML
    private Button slot6;
    @FXML
    private Button deck;
    @FXML
    private Button exitButton;
    private Card slot1Card;
    private Card slot2Card;
    private Card slot3Card;
    private Card slot4Card;
    private Card slot5Card;
    private Card slot6Card;


    Pk_Balbasaur card1 = new Pk_Balbasaur();
    Pk_Butterfree card2 = new Pk_Butterfree();
    Pk_Charmander card3 = new Pk_Charmander();
    Pk_Jigglypuff card4 = new Pk_Jigglypuff();
    Pk_Meowth card5 = new Pk_Meowth();
    Pk_Pikachu card6 = new Pk_Pikachu();
    Pk_Psyduck card7 = new Pk_Psyduck();
    Pk_Snorlax card8 = new Pk_Snorlax();
    Pk_Squirtle card9 = new Pk_Squirtle();
    Pk_Zubat card10 = new Pk_Zubat();

    List<Card> cards = new ArrayList<>(10);
    ComputerPlayer computer = new ComputerPlayer();
    HumanPlayer human = new HumanPlayer();

    Image pikachuImage = new Image(getClass().getResourceAsStream("/images/1.png"));
    Image balbasaurImage = new Image(getClass().getResourceAsStream("/images/2.png"));
    Image charmanderImage = new Image(getClass().getResourceAsStream("/images/3.png"));
    Image squirtleImage = new Image(getClass().getResourceAsStream("/images/4.png"));
    Image zubatImage = new Image(getClass().getResourceAsStream("/images/5.png"));
    Image psyduckImage = new Image(getClass().getResourceAsStream("/images/6.png"));
    Image snorlaxImage = new Image(getClass().getResourceAsStream("/images/7.png"));
    Image butterfreeImage = new Image(getClass().getResourceAsStream("/images/8.png"));
    Image jigglypuffImage = new Image(getClass().getResourceAsStream("/images/9.png"));
    Image meowthImage = new Image(getClass().getResourceAsStream("/images/10.png"));

    Image bg = new Image(getClass().getResourceAsStream("/images/bg.png"));
    int size = 10;

    List<Card> computerCardList = new ArrayList<>(3);
    List<Card> humanPlCardList = new ArrayList<>(3);
    public void startGame(ActionEvent event) {
        startButton.visibleProperty().set(false);
        Image bg_full = new Image(getClass().getResourceAsStream("/images/bg_full.png"));
        ImageView bgView = new ImageView(bg_full);
        bgView.setFitWidth(245.0);
        bgView.setFitHeight(342.0);
        deck.setGraphic(bgView);
        deck.setText("");
        slot1.setText("");
        slot2.setText("");
        slot5.setText("");
        slot6.setText("");
        slot4.setText("");
        slot3.setText("");
        initGame();
    }

    public void initGame() {
        exitButton.setVisible(false);
        size = 10;
        cards = new ArrayList<>(10);
        computer = new ComputerPlayer();
        human = new HumanPlayer();
        computerCardList = new ArrayList<>(3);
        humanPlCardList = new ArrayList<>(3);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);
        cards.add(card8);
        cards.add(card9);
        cards.add(card10);
        Random rand = new Random();
        for (int i=0;i<3; i++){
            int temp = rand.nextInt(size);
            computerCardList.add(cards.get(temp));
            size--;
            cards.remove(temp);
        }
        for (int i=0;i<3;i++) {
            int temp = rand.nextInt(size);
            humanPlCardList.add(cards.get(temp));
            size--;
            cards.remove(temp);
        }
        computer = new ComputerPlayer(1, "Computer", 0, computerCardList);
        human = new HumanPlayer(2, "You", 0, humanPlCardList);
        human.setScore(0);
        computer.setScore(0);
        updateScoreTable();
        updateHands();
    }

    public void playPokemon(Card yourPokemon, Card computerPokemon) {



        if(yourPokemon.getAttackPoint() > computerPokemon.getAttackPoint()) {
            human.setScore(human.getScore() + 5);
        }
        else if(yourPokemon.getAttackPoint() < computerPokemon.getAttackPoint()) {
            computer.setScore(computer.getScore() + 5);
        }
        removeFromComputer(computerPokemon);
        removeFromHuman(yourPokemon);
        updateScoreTable();
        drawCard();
        updateHands();
        updateScoreTable();
        showLastCards(yourPokemon, computerPokemon);
    }

    public void slot1Play() throws InterruptedException {
        playPokemon(slot1Card, playComputer());
    }

    public void slot2Play() throws InterruptedException {
        playPokemon(slot2Card, playComputer());
    }

    public void slot3Play() throws InterruptedException {
        playPokemon(slot3Card, playComputer());
    }

    public void setSlot1Card(Card slot1Card, Image img) {
        this.slot1Card = slot1Card;
        slot1.setGraphic(new ImageView(img));

    }

    public Card getSlot1Card() {
        return slot1Card;
    }

    public void setSlot2Card(Card slot2Card, Image img) {
        this.slot2Card = slot2Card;
        slot2.setGraphic(new ImageView(img));

    }

    public Card getSlot2Card() {
        return slot2Card;
    }

    public void setSlot3Card(Card slot3Card, Image img) {
        this.slot3Card = slot3Card;
        slot3.setGraphic(new ImageView(img));

    }

    public Card getSlot3Card() {
        return slot3Card;
    }

    public void setSlot4Card(Card slot4Card, Image img) {
        this.slot4Card = slot4Card;
        slot4.setGraphic(new ImageView(img));

    }

    public Card getSlot4Card() {
        return slot4Card;
    }

    public void setSlot5Card(Card slot5Card, Image img) {
        this.slot5Card = slot5Card;
        slot5.setGraphic(new ImageView(img));

    }

    public Card getSlot5Card() {
        return slot5Card;
    }

    public void setSlot6Card(Card slot6Card, Image img) {
        this.slot6Card = slot6Card;
        slot6.setGraphic(new ImageView(img));

    }

    public Card getSlot6Card() {
        return slot6Card;
    }

    public void updateScoreTable() {
        scoreLabelHuman.setText("Score: " +String.valueOf(human.getScore()));
        scoreLabelComputer.setText("Score: " + String.valueOf(computer.getScore()));
    }

    public Image findImagebyCard(Card card) {
        int index = card.getPokemonID();
        switch (index) {
            case 1:
                return pikachuImage;
            case 2:
                return balbasaurImage;
            case 3:
                return charmanderImage;
            case 4:
                return squirtleImage;
            case 5:
                return zubatImage;
            case 6:
                return psyduckImage;
            case 7:
                return snorlaxImage;
            case 8:
                return butterfreeImage;
            case 9:
                return jigglypuffImage;
            case 10:
                return meowthImage;
            default:
                break;
        }
        return null;
    }

    public void updateHands() {
        if(computer.cardList.size() == 2) {
            slot6.setDisable(true);
            slot3.setDisable(true);
        }
        else if(computer.cardList.size() == 1) {
            slot6.setDisable(true);
            slot3.setDisable(true);
            slot5.setDisable(true);
            slot2.setDisable(true);
        }
        else if(computer.cardList.size() == 0) {
            gameOver();
        }


        for (int i=0;i<human.cardList.size();i++) {
            if(i==0) {
                setSlot1Card(human.cardList.get(i),findImagebyCard(human.cardList.get(i)));
            }
            else if(i==1) {
                setSlot2Card(human.cardList.get(i), findImagebyCard(human.cardList.get(i)));
            }
            else if (i==2) {
                setSlot3Card(human.cardList.get(i), findImagebyCard(human.cardList.get(i)));
            }
        }

        for (int i=0;i<computer.cardList.size(); i++) {
            if(i==0) {
                setSlot4Card(computer.cardList.get(i),bg);
            }
            else if(i==1) {
                setSlot5Card(computer.cardList.get(i), bg);
            }
            else if(i==2) {
                setSlot6Card(computer.cardList.get(i), bg);
            }
        }





    }

    public void drawCard() {
        Random rand = new Random();
        if(size > 1) {
            int temp = rand.nextInt(size);
            computer.drawCard(cards.get(temp));
            size--;
            cards.remove(temp);
            temp = rand.nextInt(size);
            human.drawCard(cards.get(temp));
            size--;
            cards.remove(temp);
        }
        deckSizeLabel.setText(String.valueOf(size));
    }

    public Card playComputer() {
        Random rand = new Random();
        int index = rand.nextInt(computer.cardList.size());
        return computer.cardList.get(index);
    }

    public void removeFromComputer(Card pokemon) {
        for (int i=0; i<computer.cardList.size(); i++) {
            if(computer.cardList.get(i).getPokemonName() == pokemon.getPokemonName()) {
                computer.cardList.remove(i);
            }
        }
    }

    public void removeFromHuman(Card pokemon) {
        for (int i=0; i<human.cardList.size(); i++) {
            if(human.cardList.get(i).getPokemonName() == pokemon.getPokemonName()) {
                human.cardList.remove(i);
            }
        }
    }

    public void gameOver() {
        String s = "";
        if(human.getScore() > computer.getScore()) {
            s = "YOU WON YOUR SCORE: " + human.getScore();
        }
        else if (human.getScore() < computer.getScore()) {
            s = "YOU LOST YOU SCORE: " + human.getScore();
        }
        else {
            s = "YOU HAVE EQUAL SCORES: " + human.getScore();
        }
        Alert.AlertType type = Alert.AlertType.INFORMATION;
        Alert alert = new Alert(type,s);
        alert.showAndWait();
        exitButton.setVisible(true);
        deckSizeLabel.setText("REMATCH");
    }

    public void exitTheGame() {
        slot1.setDisable(true);
        slot4.setDisable(true);
        Stage stage = (Stage)startButton.getScene().getWindow();
        stage.close();
    }

    public void rematch( ) {
        if(!startButton.visibleProperty().get()) {
            initGame();
            comImageView.setImage(null);
            humImageView.setImage(null);
            deckSizeLabel.setText("4");
            slot1.setDisable(false);
            slot2.setDisable(false);
            slot3.setDisable(false);
            slot4.setDisable(false);
            slot5.setDisable(false);
            slot6.setDisable(false);
        }
    }

    public void showLastCards (Card yourPok, Card computerPok) {
        humImageView.setImage(findImagebyCard(yourPok));
        comImageView.setImage(findImagebyCard(computerPok));
    }

    public void deckClick(ActionEvent event) {
        rematch();
    }

}
