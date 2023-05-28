package bookScrabble.model.logical;

import bookScrabble.model.data.Board;
import bookScrabble.model.facade.Player;
import bookScrabble.model.facade.PlayerStreamLogic;

import java.io.*;
import java.net.Socket;
import java.util.Observable;

public class GuestModel extends Observable {
    PlayerStreamLogic playerStreamLogic = new PlayerStreamLogic();
    private Socket socket;
    public Board board = Board.getBoard();
    Player player = new Player();

    public void connectToServer(){
        try {
            socket = new Socket("localhost", 8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void streamPlayer(){
        playerStreamLogic.streamPlayer(socket, player);
    }



}

