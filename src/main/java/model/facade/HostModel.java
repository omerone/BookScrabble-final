package model.facade;

import model.data.Board;
import model.data.Tile;
import model.logical.BookScrabbleHandler;
import model.logical.MyServer;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class HostModel extends Observable {
    private Socket socket;
    private MyServer hostServer;
    private Board board = Board.getBoard();
    private List<Player> guestPlayersList = new ArrayList<>();
    private Player hostPlayer;
    private MyServer gameServer = new MyServer(8080, new BookScrabbleHandler());
    private Tile.Bag bag = Tile.Bag.getBag();
    private BuildTilesModel buildTilesModel= new BuildTilesModel();

    public HostModel() {
        gameServer.start();

    }
    public void tryPlaceWord(){

    }
}





