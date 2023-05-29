package bookScrabble.model.logical;

import bookScrabble.model.data.Board;
import bookScrabble.model.data.Player;

import java.io.*;
import java.net.Socket;
import java.util.Observable;

public class GuestModel extends Observable {
    private Socket socket;
    public Board board = Board.getBoard();
    Player player = new Player();

    public void connectToServer(){
        try {
            socket = new Socket("localhost", 8000);
            System.out.println("connected to server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

