package fr.snake.in.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class SnakeController{

    @FXML
    private GridPane gridBackground;

    @FXML
    private GridPane gridFront;

    private ImageView[][] images;

    @FXML
    public void initialize() {
        images = new ImageView[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                images[i][j] = new ImageView();
                gridBackground.add(images[i][j], i, j);
            }
        }
    }

}
