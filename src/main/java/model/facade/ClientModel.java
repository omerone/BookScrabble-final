package model.facade;

import java.io.*;
import java.net.Socket;
import java.util.Observable;
public class ClientModel extends Observable {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public void connect(String serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress, port);
        socket.connect(socket.getRemoteSocketAddress());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);
        setChanged();
        notifyObservers();
    }
    public void sendMessage(String message) {
        writer.println(message);
    }
    public String receiveMessage() throws IOException {
        return reader.readLine();
    }
    public void close() throws IOException {
        socket.close();
    }

}

