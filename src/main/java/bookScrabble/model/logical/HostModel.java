package bookScrabble.model.logical;

import bookScrabble.model.communication.GuestHandler;
import bookScrabble.model.communication.HostServer;
import bookScrabble.model.data.Board;
import bookScrabble.model.data.Player;
import bookScrabble.model.data.Tile;
import bookScrabble.model.communication.MyServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class HostModel extends Observable {

    //variables
    public Board board;
    Socket socket;
    public Player player;
    private HostServer hostServer;
    private List<Player> guestPlayersList;
    private Tile.Bag bag;

    //ctor
    public HostModel(){
        board = Board.getBoard();
        socket = null;
        player = new Player();
        guestPlayersList = new ArrayList<>();
        bag = Tile.Bag.getBag();
    }

    //methods
    public void startHostServer() {
        GuestHandler hs = new GuestHandler(new HostModel());
        hostServer = new HostServer(8000 , hs);
        hostServer.start();
        try {
            socket = new Socket("localhost", 8000);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("host server started");
    }

    public void closeHostServer() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println("close");
            out.flush();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        hostServer.close();
    }

    public int getConnectedPlayersNumber(){
        return guestPlayersList.size();
    }

    public List<Player> getGuestPlayersList() {
        return guestPlayersList;
    }

    public void addGuestPlayer(Player player) {
        guestPlayersList.add(player);
    }

    public boolean removeGuestPlayer(Player player) {
        return guestPlayersList.remove(player);
    }


}






