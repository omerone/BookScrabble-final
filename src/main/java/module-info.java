module view.bookscrabblefinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens bookScrabble.view to javafx.fxml;
    exports bookScrabble.view;
    exports bookScrabble.model.logical;
    opens bookScrabble.model.logical to javafx.fxml;
    exports gameServerLogical;
    opens gameServerLogical to javafx.fxml;
    exports bookScrabble.model.gameCommunication;
    opens bookScrabble.model.gameCommunication to javafx.fxml;
}