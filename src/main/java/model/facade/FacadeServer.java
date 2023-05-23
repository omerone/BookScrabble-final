package model.facade;

import model.logical.BookScrabbleHandler;
import model.logical.MyServer;

public class FacadeServer {

    public static void startServer() {
        MyServer myServer = new MyServer(6000, new BookScrabbleHandler());
        myServer.start();
        FacadeClient.connectToServer("192.168.1.11",6000);
    }
}