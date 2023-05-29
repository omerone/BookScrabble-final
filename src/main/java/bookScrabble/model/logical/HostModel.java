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

    public Board board = Board.getBoard();
    Socket socket = null;
    public Player player = new Player();
    private HostServer hostServer;
    private List<Player> guestPlayersList = new ArrayList<>();
    private Tile.Bag bag = Tile.Bag.getBag();
    private BuildTilesModel buildTilesModel = new BuildTilesModel();

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


    public void addGuestPlayer(Player player) {
        guestPlayersList.add(player);
    }
    public List<Player> getGuestPlayersList() {
        return guestPlayersList;
    }
}






