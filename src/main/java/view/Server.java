package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread  {
    @Override
    public void run() {
        super.run();
        connectServer();
    }
    //server connection
    public void connectServer(){
        try {
            // Create a new server socket and bind it to port 8000
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started...");

            while (true) {
                // Wait for a client to connect
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                // Create input and output streams for the socket
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                // Send a message to the client
                out.writeObject("Hello, client!");

                // Receive a message from the client
                String message = (String) in.readObject();
                System.out.println("Client sent: " + message);

                // Close the socket
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //client connection
    public void connectClient(){
        try {
            // Connect to the server on port 8000
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Connected to server...");

            // Create input and output streams for the socket
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Receive a message from the server
            String message = (String) in.readObject();
            System.out.println("Server sent: " + message);

            // Send a message to the server
            out.writeObject("Hello, server!");

            // Close the socket
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
