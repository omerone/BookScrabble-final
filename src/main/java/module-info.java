module view.bookscrabblefinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens view to javafx.fxml;
    exports view;
    exports model.logical;
    opens model.logical to javafx.fxml;
}