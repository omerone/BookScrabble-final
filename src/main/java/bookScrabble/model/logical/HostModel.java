package bookScrabble.model.logical;

import bookScrabble.model.data.Board;
import bookScrabble.model.data.Tile;
import bookScrabble.model.facade.GuestHandler;
import bookScrabble.model.facade.Player;
import bookScrabble.model.facade.PlayerStreamLogic;
import bookScrabble.model.gameCommunication.MyServer;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class HostModel extends Observable {

    PlayerStreamLogic playerStreamLogic = new PlayerStreamLogic();
    public Board board = Board.getBoard();
    Socket socket = null;
    Player player = new Player();
    private MyServer hostServer;
    private List<Player> guestPlayersList = new ArrayList<>();
    //private MyServer gameServer = new MyServer(8080, new BookScrabbleHandler());
    private Tile.Bag bag = Tile.Bag.getBag();
    private BuildTilesModel buildTilesModel = new BuildTilesModel();

    public void startHostServer() {
        hostServer = new MyServer(8000, new GuestHandler(this));
        hostServer.start();
        try {
            socket = new Socket("localhost", 8000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("host server started");
    }
    public void streamPlayer(){
        playerStreamLogic.streamPlayer(socket, player);
    }

    public void closeHostServer() {
        hostServer.close();
    }
    public int getConnectedPlayersNumber(){
        return guestPlayersList.size();
    }

//    //public void closeGameServer() {
//        gameServer.close();
//    }

    public void addGuestPlayer(Player player) {
        guestPlayersList.add(player);
    }
}






