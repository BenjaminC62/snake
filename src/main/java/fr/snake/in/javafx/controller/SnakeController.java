package fr.snake.in.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class SnakeController{

    private static final int GridSize = 15;

    @FXML
    private GridPane gridBackground;

    @FXML
    private GridPane gridFront;

    private Scene scene;

    private ImageView[][] images;

    @FXML
    public void initialize() {
        images = new ImageView[GridSize][GridSize];
        for (int i = 0; i < GridSize; i++) {
            for (int j = 0; j < GridSize; j++) {
                images[i][j] = new ImageView("D:/snakeMadeInJavaFx/snake/src/main/resources/fr/snake/in/javafx/view/images/Carré_vert_foncé.jpg");
                images[i][j].setFitHeight(2);
                images[i][j].setFitWidth(2);
                gridBackground.add(images[i][j], i, j);
            }
        }
    }

    /*
    public void setScene(Scene scene) {
        this.scene = scene;
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e ->{
            if (e.getCode() == KeyCode.UP) {
                snake.moveUp();
            } else if (e.getCode() == KeyCode.DOWN) {
                snake.moveDown();
            } else if (e.getCode() == KeyCode.LEFT) {
                snake.moveLeft();
            } else if (e.getCode() == KeyCode.RIGHT) {
                snake.moveRight();
            }
        });
    }*/







}
