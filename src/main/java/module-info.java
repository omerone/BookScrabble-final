module view.bookscrabblefinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens bookScrabble.view to javafx.fxml;
    exports bookScrabble.view;
    exports bookScrabble.model.logical;
    opens bookScrabble.model.logical to javafx.fxml;
    exports bookScrabble.model.gameLogic;
    opens bookScrabble.model.gameLogic to javafx.fxml;
    exports bookScrabble.model.communication;
    opens bookScrabble.model.communication to javafx.fxml;
}