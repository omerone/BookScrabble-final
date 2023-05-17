package model.facade;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientArea implements FacadeClient{

    @Override
    public void disconnectFromServer() {

    }

    @Override
    public void sendToServer(String command) {

    }

    @Override
    public String receiveFromServer() {
        return null;
    }
}
