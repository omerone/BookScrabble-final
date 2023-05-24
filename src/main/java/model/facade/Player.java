package model.facade;

import model.data.Tile;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    private int score;
    Tile[][] board;
    List<Tile> tilesHand;
    Tile.Bag bag = Tile.Bag.getBag();

    public Player(){
        score = 0;
        tilesHand = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Tile tile = bag.getRand();
            tilesHand.add(tile);
        }
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void addToScore(int score){
        this.score += score;
    }

}
