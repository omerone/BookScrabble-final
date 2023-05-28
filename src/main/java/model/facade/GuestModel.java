package model.facade;

import model.data.Board;

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
}

