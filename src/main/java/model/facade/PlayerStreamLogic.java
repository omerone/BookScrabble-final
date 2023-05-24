package model.facade;

import java.io.*;
import java.net.Socket;

public class PlayerStreamLogic {
    public void streamPlayer(Socket socket, Player player) {
        try {
            // Get the output stream from the socket
            OutputStream outputStream = socket.getOutputStream();

            // Create an ObjectOutputStream to write objects to the output stream
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            // Write the Player object to the output stream
            objectOutputStream.writeObject(player);

            // Flush the output stream to ensure the data is sent
            objectOutputStream.flush();

            // Close the streams
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
