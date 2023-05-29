package bookScrabble.model.logical;

import bookScrabble.model.data.Board;

import java.io.*;
import java.net.Socket;
import java.util.Observable;

public class GuestModel extends Observable {
    private Socket socket;
    InputStream inputStream;

    OutputStream outputStream;
    public Board board = Board.getBoard();
    Player player = new Player();

    public void connectToServer(String ip, int port){
        try {
            socket = new Socket(ip, port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Player getPlayer(){
        return player;
    }
}

