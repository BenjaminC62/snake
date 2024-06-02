module fr.snake.in.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.snake.in.javafx to javafx.fxml;
    exports fr.snake.in.javafx;
    exports fr.snake.in.javafx.controller;
    opens fr.snake.in.javafx.controller to javafx.fxml;
}