package bookScrabble.model.facade;

import bookScrabble.model.gameCommunication.ClientHandler;
import bookScrabble.model.logical.HostModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;

public class GuestHandler implements ClientHandler {
    private HostModel hostModel;

    public GuestHandler(HostModel hostModel) {
        this.hostModel = hostModel;
    }
    @Override
    public void handleClient(InputStream inFromclient, OutputStream outToClient) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inFromclient);
            Player player = (Player) objectInputStream.readObject();
            hostModel.addGuestPlayer(player);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {

    }
}
