package model.facade;

import model.data.Board;
import model.data.Tile;

import java.io.*;
import java.net.Socket;
import java.util.Observable;
public class GuestModel extends Observable {
    private Socket socket;
    Player player;
    public Board board = Board.getBoard();
    Player Player = new Player();


}

