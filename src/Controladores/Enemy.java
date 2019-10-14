/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author avile
 */
public class Enemy {

    private Button btn;
    private ArrayList<ImageView> powerList, enemiesList;
    private AnchorPane pane;
    private Timeline collision, respawn;
    private int puntuacion = 0;

    public Enemy(ArrayList powerList, AnchorPane pane, Button puntaje, ImageView player) {
        this.powerList = powerList;
        this.pane = pane;
        enemiesList = new ArrayList();
        collision = new Timeline();
        respawn = new Timeline();
        btn = puntaje;

        collision.getKeyFrames().add(new KeyFrame(Duration.millis(5), (event) -> {
            this.enemiesList.forEach((enemy) -> {
                this.powerList.forEach((power) -> {
                    if (enemy.getLayoutX() <= (power.getLayoutX() + power.getFitWidth())) {
                        if (power.getLayoutY() >= enemy.getLayoutY()) {
                            if ((power.getLayoutY() + power.getFitHeight()) <= (enemy.getLayoutY() + enemy.getFitHeight())) {
                                plusPoint(enemy, power);
                            }
                        }
                    }
                });
                morir(enemy, player);
            });
        }));
        collision.setCycleCount(Timeline.INDEFINITE);
        collision.play();

        respawn.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (event) -> {
            summonEntity();
        }));
        respawn.setCycleCount(Timeline.INDEFINITE);
        respawn.play();

    }

    private void summonEntity() {
        Image gato = new Image(getClass().getResourceAsStream("/Recursos/gato.png"));
        ImageView enemy = new ImageView();
        enemy.setImage(gato);
        enemy.setFitWidth(gato.getWidth() / 4);
        enemy.setFitHeight(gato.getHeight() / 4);

        Random rnd;
        rnd = new Random();

        double y = rnd.nextDouble() * 1000;
        enemy.setLayoutY(y);
        enemy.setLayoutX(pane.getPrefWidth());

        pane.getChildren().add(enemy);
        enemiesList.add(enemy);

        Timeline advanceWalk;

        advanceWalk = new Timeline();

        advanceWalk.getKeyFrames().add(new KeyFrame(Duration.millis(6), (event) -> {
            enemy.setLayoutX(enemy.getLayoutX() - 1);
        }));
        advanceWalk.setCycleCount(3000);
        advanceWalk.play();
    }

    private void plusPoint(ImageView enemy, ImageView power) {
        enemy.setFitHeight(1);
        enemy.setFitWidth(1);
        power.setFitWidth(1);
        power.setFitHeight(1);
        power.setLayoutX(-3000);
        puntuacion++;
        btn.setText("" + puntuacion);
    }

    private void morir(ImageView enemy, ImageView player) {
        if (enemy.getLayoutX() <= (player.getLayoutX() + player.getFitWidth())) {
            if (player.getLayoutY() >= enemy.getLayoutY()) {
                if ((player.getLayoutY() + player.getFitHeight()) <= (enemy.getLayoutY() + enemy.getFitHeight())) {
                    if ((enemy.getLayoutX() + enemy.getFitWidth()) >= player.getLayoutX()) {
                        System.exit(0);
                    }
                }
            }
        }
    }

}
