package bookScrabble.model.communication;


import bookScrabble.model.communication.ClientHandler;
import bookScrabble.model.logical.HostModel;

import java.io.*;
import java.util.Scanner;

public class GuestHandler implements ClientHandler {
    private HostModel hostModel;

    public GuestHandler(HostModel hostModel) {
        this.hostModel = hostModel;
    }

    @Override
    public void handleClient(InputStream inFromclient, OutputStream outToClient) {
        Scanner scanner = new Scanner(inFromclient);
        String message = scanner.nextLine();
        String[] messageSplit = message.split(";");
        if (messageSplit[0].equals("startNewGame")) {
            hostModel.startHostServer();
        } else if (messageSplit[0].equals("getBoard")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
                objectOutputStream.writeObject(hostModel.board);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (messageSplit[0].equals("getTilesHand")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
                objectOutputStream.writeObject(hostModel.player.tilesHand);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (messageSplit[0].equals("getScore")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
                objectOutputStream.writeObject(hostModel.player.getScore());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (messageSplit[0].equals("getBagSize")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
                objectOutputStream.writeObject(hostModel.player.bag.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (messageSplit[0].equals("getBag")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
                objectOutputStream.writeObject(hostModel.player.bag);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (messageSplit[0].equals("getPlayers")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
                objectOutputStream.writeObject(hostModel.getGuestPlayersList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {

    }
}
