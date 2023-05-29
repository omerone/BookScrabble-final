package bookScrabble.model.logical;

import bookScrabble.model.communication.GuestHandler;
import bookScrabble.model.data.Board;
import bookScrabble.model.data.Tile;
import bookScrabble.model.communication.MyServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class HostModel extends Observable {

    public Board board = Board.getBoard();
    public Socket socket = null;
    InputStream inputStream;

    OutputStream outputStream;
    public Player player = new Player();
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
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("host server started");
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
    public List<Player> getGuestPlayersList() {
        return guestPlayersList;
    }
    public void StreamMessage(String message) {
        try {
            outputStream.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}






