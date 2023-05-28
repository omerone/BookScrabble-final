package bookScrabble.model.gameCommunication;

import bookScrabble.model.gameCommunication.ClientHandler;

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
