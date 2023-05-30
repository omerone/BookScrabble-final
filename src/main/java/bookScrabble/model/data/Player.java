package bookScrabble.model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {

    private final String playerID;
    private String playerName;
    private int playerIndex;
    private int playerScore;
    private List<Tile> playerTilesHand;


    public Player(String name) {
        this.playerName = name;
        this.playerScore = 0;
        this.playerID = "";
        this.playerTilesHand = new ArrayList<>();
    }

    public String getPlayerSocketID() {
        return playerID;
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
        return playerTilesHand;
    }

    public void setTilesHand(List<Tile> tilesHand) {
        this.playerTilesHand = tilesHand;
    }

    public void sendToGuest(String getBoard) {

    }
}
