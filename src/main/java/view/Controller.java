package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.facade.FacadeServer;
import test.MainTrain1;

import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;
    int port1;
    long ip1;

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


    @FXML private Label myLable;
    @FXML private TextField portTextField;
    @FXML private TextField ipTextField;
    @FXML private Button myButton;




    public void submitIpAndPort(ActionEvent event){
        try {
            ip1 = Long.parseLong(portTextField.getText());
            port1 = Integer.parseInt(ipTextField.getText());
//
            myLable.setText("Connect successfully to the server ! ");
        }
        catch (NumberFormatException e){
            myLable.setText("Please enter a valid IP and valid Port");
        }
        catch (Exception e){
            myLable.setText("Error!");
        }
    }

    public void startTest(){
        FacadeServer.startServer();
    }

}