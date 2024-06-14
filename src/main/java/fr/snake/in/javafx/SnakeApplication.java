package fr.snake.in.javafx;

import fr.snake.in.javafx.controller.SnakeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeApplication.class.getResource("view/snake-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 750);
        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();

        SnakeController snakeController = fxmlLoader.getController();
        snakeController.setScene(scene);
        snakeController.spawnFood();

    }

    public static void main(String[] args) {
        launch();
    }
}