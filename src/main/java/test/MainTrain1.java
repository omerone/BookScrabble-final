package test;

import model.logical.MainTrain;
import model.logical.MyServer;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class MainTrain1 {
    //server com.example.demo.test
    public static void serverAndClientTest(){
        boolean ok=true;
        try {
            client1();
        }
        catch(Exception e) {
            System.out.println("some exception was thrown while testing your server, cannot continue the test (-100)");
            ok=false;
        }
    }

    public static void client1() throws Exception{
        Socket server=new Socket("localhost", 6000);
        Random r=new Random();
        String text = ""+(1000+r.nextInt(100000));
        String rev=new StringBuilder(text).reverse().toString();
        PrintWriter outToServer=new PrintWriter(server.getOutputStream());
        Scanner in=new Scanner(server.getInputStream());
        outToServer.println(text);
        outToServer.flush();
        String response=in.next();
        if(response==null || !response.equals(rev))
            System.out.println("problem getting the right response from your server, cannot continue the test (-100)");
        in.close();
        outToServer.println(text);
        outToServer.close();
        server.close();
    }






    //buttons com.example.demo.test
    public static void buttonsTest(){

    }





    //Main
    public static void main(String[] args) {
        serverAndClientTest();
        buttonsTest();
        System.out.println("done testing");
    }
}