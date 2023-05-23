package model.facade;

import model.logical.ClientHandler;

import java.io.InputStream;
import java.io.OutputStream;

public class HostServerHandler implements ClientHandler {
    @Override
    public void handleClient(InputStream inFromclient, OutputStream outToClient) {

    }

    @Override
    public void close() {

    }
}
