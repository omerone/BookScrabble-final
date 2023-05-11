package model.facade;
import java.net.InetAddress;
import java.net.UnknownHostException;

import model.logical.BookScrabbleHandler;
import model.logical.MyServer;

import java.util.Observable;

public class Model extends Observable {

    public void startServer() {
        MyServer myServer = new MyServer(3000, new BookScrabbleHandler());
        myServer.start();
        setChanged();
        notifyObservers();
    }
}