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

    public Board board = Board.getBoard();
    Socket socket = null;
    Player Player = new Player();
    private MyServer hostServer;
    private List<Player> guestPlayersList = new ArrayList<>();
    private MyServer gameServer = new MyServer(8080, new BookScrabbleHandler());
    private Tile.Bag bag = Tile.Bag.getBag();
    private BuildTilesModel buildTilesModel= new BuildTilesModel();

    public HostModel() {
        gameServer.start();
    }

}





