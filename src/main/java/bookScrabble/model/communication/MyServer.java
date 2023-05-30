package bookScrabble.model.communication;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.*;

public class MyServer {

    private final int port;
    private final ClientHandler ch;
    private volatile boolean stop;
    Map<String , Socket> players;

    public MyServer(int port, ClientHandler clientHandler){
        this.port = port;
        this.ch = clientHandler;
        this.stop = false;
        players = new HashMap <String, Socket>();
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
                String id =UUID.randomUUID().toString().substring(0,6);
                players.put(id , aClient);
                ping(id);
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

    private void ping(String clientID) {
        updateSpecificPlayer(clientID, "ping:" + clientID);
    }

    public void updateSpecificPlayer(String id, Object obj) {

        Socket s = players.get(id);
        PrintWriter out;
        try {
            if (s != null) {
                out = new PrintWriter(s.getOutputStream());
                out.println(obj);
                out.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
