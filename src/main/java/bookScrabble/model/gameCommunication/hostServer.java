package bookScrabble.model.gameCommunication;

import bookScrabble.model.gameCommunication.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class hostServer {

    private final int port;
    private final ClientHandler ch;
    private volatile boolean stop;

    public hostServer(int port, ClientHandler clientHandler){
        this.port = port;
        this.ch = clientHandler;
        this.stop = false;
    }

    public void start (){
        new Thread(()-> {
            try {
                runServer();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void close() {
        stop = true;
    }

    private void runServer()throws Exception{
        ServerSocket server = new ServerSocket(port);
        server.setSoTimeout(1000);
        while (!stop) {
            try {
                Socket aClient = server.accept();
                try {
                    ch.handleClient(aClient.getInputStream(), aClient.getOutputStream());

                    aClient.getInputStream();
                    aClient.getOutputStream();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (SocketTimeoutException e) {
                e.printStackTrace();
            }
        }
        server.close();
    }
}
