package bookScrabble.model.communication;

import bookScrabble.model.logical.GameManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;


public class HostServer {

    private final int port;
    private final ClientHandler ch;
    private volatile boolean stop;
    Map<String , Socket> playersSockets;

    public HostServer(int port){
        this.port = port;
        this.ch = new GuestHandler();
        this.stop = false;
        playersSockets = new HashMap<>();
    }

    public void close() {
        stop = true;
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

    private void runServer()throws Exception{
        ServerSocket server = new ServerSocket(port);
        server.setSoTimeout(1000);
        //waiting for clients to update
        while (!stop) {
            //running and geting updates from clients
            while(!GameManager.getInstance().isGameStarted()){
                try {
                    Socket aClient = server.accept();
                    if(playersSockets.size() < 4){
                        Scanner scanner = new Scanner(aClient.getInputStream());
                        String name;
                        if(scanner.hasNextLine()){
                            name = scanner.nextLine();
                            playersSockets.put(name+playersSockets.size() , aClient);
                            GameManager.getInstance().addPlayer(name+playersSockets.size());
                        }
                    }
                }
                catch (SocketTimeoutException e) {
                    e.printStackTrace();
                }
            }

            //after game started taking care of clients
            while(GameManager.getInstance().isGameStarted()){


            }
        }
        server.close();
    }
}
