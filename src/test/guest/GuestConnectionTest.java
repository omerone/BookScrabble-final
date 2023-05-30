package guest;

import bookScrabble.model.communication.GuestHandler;
import bookScrabble.model.communication.HostServer;
import bookScrabble.model.logical.HostModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GuestConnectionTest {
    public static void main(String[] args) {
        HostModel hm = new HostModel();
        HostServer host = new HostServer(8000, new GuestHandler(hm));
        host.start();

        // Simulate client connection and data sending

        try{
            Socket clientSocket = new Socket("localhost", 8000);
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Send a test message to the server
            String testMessage = "StartNewGame";
            outputStream.write(testMessage.getBytes());
            outputStream.flush();

            // Read the response from the server
            byte[] responseBytes = new byte[1024];
            int byteRead = inputStream.read(responseBytes);
            String response = new String(responseBytes, 0, byteRead);
            System.out.println("Server response: " + response);

            // Close the connection
            clientSocket.close();

        } catch (IOException e){
            e.printStackTrace();
        }
        host.close();
    }
}
