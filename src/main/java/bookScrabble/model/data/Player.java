package bookScrabble.model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {

    private final String playerSocketID;
    private String playerName;
    private String tileLottery;
    private int playerIndex;
    private int playerScore;


    public Player() {
        this.playerName = "Default";
        this.playerScore = 0;
        this.playerSocketID = "";
    }


}
