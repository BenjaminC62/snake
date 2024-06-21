package fr.snake.in.javafx.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.Random;

public class SnakeController {

    private static final int GRIDSIZE = 15;
    private int positionPlayerX = GRIDSIZE / 2;
    private int positionPlayerY = GRIDSIZE / 2;

    @FXML
    private GridPane gridBackground;

    @FXML
    private GridPane gridFront;

    private Scene scene;
    private ImageView[][] images;
    private ImageView[][] positionsPlayer;
    private Timeline timeline;
    private Direction currentDirection = Direction.RIGHT;

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            switch (e.getCode()) {
                case RIGHT -> currentDirection = Direction.RIGHT;
                case LEFT -> currentDirection = Direction.LEFT;
                case UP -> currentDirection = Direction.UP;
                case DOWN -> currentDirection = Direction.DOWN;
            }
        });
        startTimeline();
    }

    @FXML
    public void initialize() {
        images = new ImageView[GRIDSIZE][GRIDSIZE];
        positionsPlayer = new ImageView[GRIDSIZE][GRIDSIZE];
        for (int i = 0; i < GRIDSIZE; i++) {
            for (int j = 0; j < GRIDSIZE; j++) {
                // Background
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

                // Front - player
                positionsPlayer[i][j] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/transparent.png").toExternalForm());
                positionsPlayer[i][j].setFitHeight(50);
                positionsPlayer[i][j].setFitWidth(50);
                gridFront.add(positionsPlayer[i][j], i, j);
            }
        }
        
        positionsPlayer[positionPlayerX][positionPlayerY] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/player.jpg").toExternalForm());
        positionsPlayer[positionPlayerX][positionPlayerY].setFitHeight(50);
        positionsPlayer[positionPlayerX][positionPlayerY].setFitWidth(50);
        gridFront.add(positionsPlayer[positionPlayerX][positionPlayerY], positionPlayerX, positionPlayerY);
    }

    private void startTimeline() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.8), event -> movePlayer()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void movePlayer() {
        gridFront.getChildren().remove(positionsPlayer[positionPlayerX][positionPlayerY]);

        positionsPlayer[positionPlayerX][positionPlayerY] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/transparent.png").toExternalForm());
        positionsPlayer[positionPlayerX][positionPlayerY].setFitHeight(50);
        positionsPlayer[positionPlayerX][positionPlayerY].setFitWidth(50);
        gridFront.add(positionsPlayer[positionPlayerX][positionPlayerY], positionPlayerX, positionPlayerY);

        switch (currentDirection) {
            case RIGHT -> positionPlayerX = (positionPlayerX + 1) % GRIDSIZE;
            case LEFT -> positionPlayerX = (positionPlayerX - 1 + GRIDSIZE) % GRIDSIZE;
            case UP -> positionPlayerY = (positionPlayerY - 1 + GRIDSIZE) % GRIDSIZE;
            case DOWN -> positionPlayerY = (positionPlayerY + 1) % GRIDSIZE;
        }

        positionsPlayer[positionPlayerX][positionPlayerY] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/player.jpg").toExternalForm());
        positionsPlayer[positionPlayerX][positionPlayerY].setFitHeight(50);
        positionsPlayer[positionPlayerX][positionPlayerY].setFitWidth(50);
        gridFront.add(positionsPlayer[positionPlayerX][positionPlayerY], positionPlayerX, positionPlayerY);
    }

    public void spawnFood() {
        Random rand = new Random();
        int pomme1, pomme2;
        do {
            pomme1 = rand.nextInt(GRIDSIZE);
            pomme2 = rand.nextInt(GRIDSIZE);
        } while (pomme1 == pomme2);

        images[pomme1][pomme1] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/pomme.png").toExternalForm());
        images[pomme1][pomme1].setFitHeight(50);
        images[pomme1][pomme1].setFitWidth(50);
        gridBackground.add(images[pomme1][pomme1], pomme1, pomme1);
        images[pomme2][pomme2] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/pomme.png").toExternalForm());
        images[pomme2][pomme2].setFitHeight(50);
        images[pomme2][pomme2].setFitWidth(50);
        gridBackground.add(images[pomme2][pomme2], pomme2, pomme2);
    }
}
