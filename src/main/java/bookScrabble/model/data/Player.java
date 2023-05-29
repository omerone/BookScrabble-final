package bookScrabble.model.data;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {

    private final String playerSocketID;
    private String playerName;
    private int playerIndex;
    private int playerScore;
    private List<Tile> tilesHand;


    public Player() {
        this.playerName = "Default";
        this.playerScore = 0;
        this.playerSocketID = "";
    }

    public String getPlayerSocketID() {
        return playerSocketID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public List<Tile> getTilesHand() {
        return tilesHand;
    }

    public void setTilesHand(List<Tile> tilesHand) {
        this.tilesHand = tilesHand;
    }

}
