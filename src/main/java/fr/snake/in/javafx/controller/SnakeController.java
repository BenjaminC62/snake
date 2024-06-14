package fr.snake.in.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class SnakeController{

    private static final int GRIDSIZE = 15;
    private int positionPlayerInArray = GRIDSIZE/2;

    //Images
    private final ImageView fondVertLight= new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/Carré_vert_foncé.jpg").toExternalForm());
    private final ImageView fondVertDark= new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/images.png").toExternalForm());
    private final ImageView PlayerImage = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/player.jpg").toExternalForm());
    private final ImageView foodImage = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/pomme.png").toExternalForm());
    private final ImageView transparentImage = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/transparent.png").toExternalForm());
    

    @FXML
    private GridPane gridBackground;

    @FXML
    private GridPane gridFront;

    private Scene scene;

    private ImageView[][] images;
    private ImageView[][] positionsPlayer;

    public void setScene(Scene scene) {
        this.scene = scene;
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e ->{
            if(e.getCode() == KeyCode.RIGHT){
                if(positionPlayerInArray != 15){
                    positionPlayerInArray++;
                    positionsPlayer[positionPlayerInArray][GRIDSIZE/2].setImage(positionPlayerInArray);
                    positionsPlayer[positionPlayerInArray][GRIDSIZE/2].setFitHeight(50);
                    positionsPlayer[positionPlayerInArray][GRIDSIZE/2].setFitWidth(50);
                    gridFront.add(positionsPlayer[positionPlayerInArray][GRIDSIZE/2], positionPlayerInArray--, GRIDSIZE/2);
                    positionsPlayer[positionPlayerInArray--][(GRIDSIZE/2)] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/transparent.png").toExternalForm());
                    gridFront.add(positionsPlayer[positionPlayerInArray--][GRIDSIZE/2], positionPlayerInArray--, GRIDSIZE/2);
                }
                else{
                    positionPlayerInArray = 0;
                }
            }
        });
    }

    @FXML
    public void initialize() {
        images = new ImageView[GRIDSIZE][GRIDSIZE];
        positionsPlayer = new ImageView[GRIDSIZE][GRIDSIZE];
        for (int i = 0; i < GRIDSIZE; i++) {
            for (int j = 0; j < GRIDSIZE; j++) {
                //Background
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

                //Front - player
                if((i != (GRIDSIZE/2) && j != (GRIDSIZE/2))){
                    positionsPlayer[i][j] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/transparent.png").toExternalForm());
                    positionsPlayer[i][j].setFitHeight(50);
                    positionsPlayer[i][j].setFitWidth(50);
                    gridFront.add(positionsPlayer[i][j], i, j);
                }else{
                    positionsPlayer[positionPlayerInArray][positionPlayerInArray] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/player.jpg").toExternalForm());
                    positionsPlayer[positionPlayerInArray][positionPlayerInArray].setFitHeight(50);
                    positionsPlayer[positionPlayerInArray][positionPlayerInArray].setFitWidth(50);
                    gridFront.add(positionsPlayer[positionPlayerInArray][positionPlayerInArray], (GRIDSIZE/2), (GRIDSIZE/2));
                }
            }
        }

    }

    public void movePlayerEveryTime(){

    }

    public void spawnFood(){
        Random rand = new Random();
        int pomme1;
        int pomme2;
        do{
             pomme1 = rand.nextInt(15);
             pomme2 = rand.nextInt(15);
        }while (pomme1 == pomme2);


        images[pomme1][pomme1].setImage(foodImage.getImage());
        images[pomme1][pomme1].setFitHeight(50);
        images[pomme1][pomme1].setFitWidth(50);
        gridBackground.add(images[pomme1][pomme1], pomme1, pomme1);
        images[pomme2][pomme2] = new ImageView(getClass().getResource("/fr/snake/in/javafx/view/images/pomme.png").toExternalForm());
        images[pomme2][pomme2].setFitHeight(50);
        images[pomme2][pomme2].setFitWidth(50);
        gridBackground.add(images[pomme2][pomme2], pomme2, pomme2);
    }

}
