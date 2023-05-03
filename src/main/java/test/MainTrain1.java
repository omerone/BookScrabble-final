package test;

import view.Server;

public class MainTrain1 {
    //server com.example.demo.test
    public static void serverAndClientTest(){
        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();
        server.connectClient();
    }

    //buttons com.example.demo.test
    public static void buttonsTest(){

    }


    //Main
    public static void main(String[] args) {
           serverAndClientTest();
           buttonsTest();
    }
}