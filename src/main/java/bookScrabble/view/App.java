package bookScrabble.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("bookScrabble.view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
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