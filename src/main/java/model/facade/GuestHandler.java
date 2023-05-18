package model.facade;

import model.logical.ClientHandler;

import java.io.InputStream;
import java.io.OutputStream;

public class GuestHandler implements ClientHandler {

    private GuestModel guestModel;
    public GuestHandler(GuestModel guestModel){
        this.guestModel = guestModel;
    }
    @Override
    public void handleClient(InputStream inFromclient, OutputStream outToClient) {
        inFromclient.toString();

    }

    @Override
    public void close() {

    }
}
