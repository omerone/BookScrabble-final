package bookScrabble.model.logical;

import bookScrabble.model.communication.HostServer;
import bookScrabble.model.data.Board;
import bookScrabble.model.data.Player;
import bookScrabble.model.data.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    private static GameManager instance = null;
    private HostServer hostServer;
    private Board board;
    private Tile.Bag bag;
    private Map<String , Player> players;
    boolean isGameStarted = false;

    private GameManager(){
        hostServer = new HostServer(8000);
        hostServer.start();
        board = Board.getBoard();
        bag = Tile.Bag.getBag();
        players = new HashMap<>();
    }

    public static GameManager getInstance(){
        if(instance == null){
            instance = new GameManager();
        }
        return instance;
    }
    public void startGame() {
        isGameStarted = true;
    }

    public void stopGame(boolean gameStarted) {
        isGameStarted = false;
    }
    public boolean isGameStarted(){
        return isGameStarted;
    }
    public void addPlayer(String name){
        players.put(name , new Player(name));
    }
    public void removePlayer(String name){
        players.remove(name);
    }
    public Map<String, Player> getPlayers(){
        return players;
    }


}
