package bookScrabble.model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {

    private final String playerSocketID;
    private String playerName;
    private int playerScore;
    private int playerIndex;
    private List<Tile> tilesHand;
    private Tile.Bag bag = Tile.Bag.getBag();


    public Player() {
        this.playerName = "Default";
        this.playerScore = 0;
        this.playerSocketID = "";
        tilesHand = new ArrayList<>();
    }

    public int getScore() {
        return playerScore;
    }

    public List<Tile> getTilesHand() {
        return tilesHand;
    }

    public Tile.Bag getBag() {
        return bag;
    }
}
