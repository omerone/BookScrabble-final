package model.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//like food interface
public interface FacadeClient {
    public static void connectToServer(String ip, int port) {
        try {
            Socket socket = new Socket(ip, port);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while ((userInput = consoleInput.readLine()) != null) {
                output.println(userInput); // Send user input to the server

                String serverResponse = input.readLine(); // Receive response from the server
                System.out.println("Server response: " + userInput);
            }
            socket.close();
            input.close();
            output.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnectFromServer();
    public void sendToServer(String command);
    public String receiveFromServer();
}
