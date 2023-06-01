package bookScrabble.model.logical;

import bookScrabble.model.data.Board;
import bookScrabble.model.data.Player;

import java.io.*;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

public class GuestModel extends Observable {
    PrintWriter pw;
    Scanner sc;
    Socket socket;


    public GuestModel(String name){
        connectToServer(name);
        waitingForServerUpdate();
    }

    public void connectToServer(String name){
        try {
            socket = new Socket("localhost", 8000);
            pw = new PrintWriter(socket.getOutputStream());
            pw.println(name);
            sc = new Scanner(socket.getInputStream());
            System.out.println("connected to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitingForServerUpdate(){
        new Thread(()->{
            while(socket.isConnected()){
                String line = sc.nextLine();
                //host can send back : error , wordisnotexict ....
                switch (line){
                    case "close" ->{
                        System.out.println("server closed");
                        break;
                    }
                    case "start" ->{
                        System.out.println("game started");
                        break;
                    }
                    case "notYourTurn" ->{
                        System.out.println("not your turn");
                        break;
                    }
                    case "yourTurn" ->{
                        System.out.println("your turn");
                        break;
                    }
                    case "gameOver" ->{
                        System.out.println("game over");
                        break;
                    }

                    default -> {
                        System.out.println("server sent: " + line);
                    }
                }
            }
        }).start();
    }
}

