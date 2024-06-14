package fr.snake.in.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class SnakeController{

    private static final int GRIDSIZE = 15;

    @FXML
    private GridPane gridBackground;

    @FXML
    private GridPane gridFront;

    private Scene scene;

    private ImageView[][] images;
    private ImageView[][] positionsPlayer;

    @FXML
    public void initialize() {
        images = new ImageView[GRIDSIZE][GRIDSIZE];
        positionsPlayer = new ImageView[GRIDSIZE][GRIDSIZE];
        for (int i = 0; i < GRIDSIZE; i++) {
            for (int j = 0; j < GRIDSIZE; j++) {
                ImageView imageView;
                if ((i + j) % 2 == 0) {
                    imageView = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/Carré_vert_foncé.jpg").toExternalForm());
                } else {
                    imageView = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/images.png").toExternalForm());
                }
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                images[i][j] = imageView;
                gridBackground.add(imageView, i, j);
            }
        }
        positionsPlayer[0][0] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/player.jpg").toExternalForm());
        positionsPlayer[0][0].setFitHeight(50);
        positionsPlayer[0][0].setFitWidth(50);
        gridFront.add(positionsPlayer[0][0], GRIDSIZE/2, GRIDSIZE/2);
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
