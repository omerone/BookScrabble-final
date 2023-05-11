package model.facade;

import model.logical.BookScrabbleHandler;
import model.logical.MyServer;

import java.util.Observable;
import java.util.Observer;

public class ServerModel extends Observable  {

    public void startServer() {
        MyServer myServer = new MyServer(3000, new BookScrabbleHandler());
        myServer.start();
        setChanged();
        notifyObservers();
    }

}