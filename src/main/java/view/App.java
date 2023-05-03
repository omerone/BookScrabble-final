package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);

        //creating new thread for the server. and the first thread is for the client.
        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();

        stage.setScene(scene);
        //adding icon to the game
        Image anotherIcon = new Image("file:src files/bookScrabble.jpg");
        stage.getIcons().add(anotherIcon);
        stage.setTitle("BookScrabble Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}