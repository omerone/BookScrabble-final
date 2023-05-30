package bookScrabble.model.communication;

import bookScrabble.model.logical.GameManager;
import bookScrabble.model.logical.HostModel;

import java.io.*;
import java.util.Scanner;

public class GuestHandler implements ClientHandler {

    @Override
    public void handleClient(InputStream inFromclient, OutputStream outToClient) {
        GameManager gameManager = GameManager.getInstance();
        Scanner scanner = new Scanner(inFromclient);
        String message = scanner.nextLine();
        String[] messageSplit = message.split(";");

        if(messageSplit[0].equals("close")){
            return;
        }
        if (messageSplit[0].equals("startNewGame")) {

        }
        else if (messageSplit[0].equals("getBoard")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
            //    objectOutputStream.writeObject(hostModel.board);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (messageSplit[0].equals("getTilesHand")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
              //  objectOutputStream.writeObject(hostModel.player.getTilesHand());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (messageSplit[0].equals("getScore")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
                //objectOutputStream.writeObject(hostModel.player.getPlayerScore());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (messageSplit[0].equals("getBagSize")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
                //objectOutputStream.writeObject(hostModel.player.getTilesHand().size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (messageSplit[0].equals("getBag")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
             //   objectOutputStream.writeObject(hostModel.player.getTilesHand());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (messageSplit[0].equals("getPlayers")) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outToClient);
              //  objectOutputStream.writeObject(hostModel.getGuestPlayersList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {

    }
}
