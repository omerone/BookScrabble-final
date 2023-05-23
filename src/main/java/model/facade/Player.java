package model.facade;

import model.data.Tile;

import java.util.ArrayList;
import java.util.List;

public class Player {
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

}
