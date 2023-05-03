package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import viewModel.ViewModel;

import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;

    //FXML layers for the buttons.
    public void playLocal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Play-Local.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void settings(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void guestMode(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Guest-Mode.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToHomeScreen(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //server com.example.demo.test
    public void serverAndClientTest(){
        Server server = new Server();
        server.connectClient();
    }


}