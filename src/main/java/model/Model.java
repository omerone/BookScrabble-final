package model;
import java.net.InetAddress;
import java.net.UnknownHostException;

import model.logical.BookScrabbleHandler;
import model.logical.MyServer;

import java.util.Observable;

public class Model extends Observable {
    private final MyServer myServer;
    public Model() {
       myServer = new MyServer(3000, new BookScrabbleHandler() {
            @Override
            public void handleClient() {
                System.out.println("client connected");
            }
        });
    }
    public void startServer(){
        myServer.start();
        setChanged();
        notifyObservers();
    }


}
