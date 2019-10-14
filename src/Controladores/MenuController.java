/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import isabelthegame.RecursosGlobales;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author avile
 */
public class MenuController implements Initializable {

    @FXML
    private ImageView bkg0;
    @FXML
    private ImageView bkg1;
    @FXML
    private ImageView bkg2;
    @FXML
    private ImageView bkg3;
    @FXML
    private ImageView bkg11;
    @FXML
    private ImageView bkg22;
    @FXML
    private ImageView bkg33;
    @FXML
    private ImageView bkg4;
    @FXML
    private ImageView bkg44;

    @FXML
    private ImageView imageSound;
    private Timeline timeline1, timeline2, timeline3, timeline4;
    private KeyValue value1, value11, value2, value22, value3, value33, value4, value44;
    private KeyFrame frame1, frame2, frame3, frame4;
    @FXML
    private AnchorPane padre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        applyResolutions();
        backgroundMovement();
    }

    @FXML
    private void play(ActionEvent event) throws IOException {
        Stage stage = new Stage(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/Diseños/Juego.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaxWidth(RecursosGlobales.getWidth());
        stage.setMaxHeight(RecursosGlobales.getHeight());
        stage.setMinWidth(RecursosGlobales.getWidth());
        stage.setMinHeight(RecursosGlobales.getHeight());
        if (RecursosGlobales.isFullSize()) {
            stage.setX(0);
            stage.setY(0);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
            stage.fullScreenProperty().addListener((observable) -> {
                stage.setIconified(true);
                stage.setFullScreen(true);
            });
        }
        stage.show();
        Button btn = (Button) event.getSource();
        btn.getScene().getWindow().hide();
    }

    @FXML
    private void options(ActionEvent event) throws IOException {
        Stage stage = new Stage(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/Diseños/Options.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaxWidth(RecursosGlobales.getWidth());
        stage.setMaxHeight(RecursosGlobales.getHeight());
        stage.setMinWidth(RecursosGlobales.getWidth());
        stage.setMinHeight(RecursosGlobales.getHeight());
        if (RecursosGlobales.isFullSize()) {
            stage.setX(0);
            stage.setY(0);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
            stage.fullScreenProperty().addListener((observable) -> {
                stage.setIconified(true);
                stage.setFullScreen(true);
            });
        }
        stage.show();
        Button btn = (Button) event.getSource();
        btn.getScene().getWindow().hide();
    }

    @FXML
    private void credits(ActionEvent event) throws IOException {
        Stage stage = new Stage(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/Diseños/Credits.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaxWidth(RecursosGlobales.getWidth());
        stage.setMaxHeight(RecursosGlobales.getHeight());
        stage.setMinWidth(RecursosGlobales.getWidth());
        stage.setMinHeight(RecursosGlobales.getHeight());
        if (RecursosGlobales.isFullSize()) {
            stage.setX(0);
            stage.setY(0);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
            stage.fullScreenProperty().addListener((observable) -> {
                stage.setIconified(true);
                stage.setFullScreen(true);
            });
        }
        stage.show();
        Button btn = (Button) event.getSource();
        btn.getScene().getWindow().hide();
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void changeSoundValue(ActionEvent event) {
        soundValue();
    }

    private void soundValue() {
        if (RecursosGlobales.isSound()) {
            imageSound.setImage(new Image(getClass().getResource("/Recursos/mute.png").toExternalForm()));
            RecursosGlobales.pause();
        } else {
            imageSound.setImage(new Image(getClass().getResource("/Recursos/sound.png").toExternalForm()));
            RecursosGlobales.play();
        }
        RecursosGlobales.setSoundValue(!RecursosGlobales.isSound());
    }

    private void backgroundMovement() {
        value1 = new KeyValue(bkg1.translateXProperty(), -RecursosGlobales.getWidth());
        value11 = new KeyValue(bkg11.translateXProperty(), -RecursosGlobales.getWidth());
        value2 = new KeyValue(bkg2.translateXProperty(), -RecursosGlobales.getWidth());
        value22 = new KeyValue(bkg22.translateXProperty(), -RecursosGlobales.getWidth());
        value3 = new KeyValue(bkg3.translateXProperty(), -RecursosGlobales.getWidth());
        value33 = new KeyValue(bkg33.translateXProperty(), -RecursosGlobales.getWidth());
        value4 = new KeyValue(bkg4.translateXProperty(), -RecursosGlobales.getWidth());
        value44 = new KeyValue(bkg44.translateXProperty(), -RecursosGlobales.getWidth());

        frame1 = new KeyFrame(Duration.seconds(40), value1, value11);
        frame2 = new KeyFrame(Duration.seconds(25), value2, value22);
        frame3 = new KeyFrame(Duration.seconds(15), value3, value33);
        frame4 = new KeyFrame(Duration.seconds(8), value4, value44);

        timeline1 = new Timeline();
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.getKeyFrames().add(frame1);
        timeline1.play();
        
        timeline2 = new Timeline();
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.getKeyFrames().add(frame2);
        timeline2.play();
        
        timeline3 = new Timeline();
        timeline3.setCycleCount(Timeline.INDEFINITE);
        timeline3.getKeyFrames().add(frame3);
        timeline3.play();
        
        timeline4 = new Timeline();
        timeline4.setCycleCount(Timeline.INDEFINITE);
        timeline4.getKeyFrames().add(frame4);
        timeline4.play();

        if (RecursosGlobales.isSound()) {
            imageSound.setImage(new Image(getClass().getResource("/Recursos/sound.png").toExternalForm()));
        } else {
            imageSound.setImage(new Image(getClass().getResource("/Recursos/mute.png").toExternalForm()));
        }
    }

    private void applyResolutions() {
        padre.setPrefSize(RecursosGlobales.getWidth(), RecursosGlobales.getHeight());

        bkg0.setFitWidth(RecursosGlobales.getWidth());
        bkg0.setFitHeight(RecursosGlobales.getHeight());

        bkg1.setFitWidth(RecursosGlobales.getWidth());
        bkg1.setFitHeight(RecursosGlobales.getHeight());

        bkg11.setFitWidth(RecursosGlobales.getWidth());
        bkg11.setFitHeight(RecursosGlobales.getHeight());

        bkg2.setFitWidth(RecursosGlobales.getWidth());
        bkg2.setFitHeight(RecursosGlobales.getHeight());

        bkg22.setFitWidth(RecursosGlobales.getWidth());
        bkg22.setFitHeight(RecursosGlobales.getHeight());

        bkg3.setFitWidth(RecursosGlobales.getWidth());
        bkg3.setFitHeight(RecursosGlobales.getHeight());

        bkg33.setFitWidth(RecursosGlobales.getWidth());
        bkg33.setFitHeight(RecursosGlobales.getHeight());

        bkg4.setFitWidth(RecursosGlobales.getWidth());
        bkg4.setFitHeight(RecursosGlobales.getHeight());

        bkg44.setFitWidth(RecursosGlobales.getWidth());
        bkg44.setFitHeight(RecursosGlobales.getHeight());

        bkg11.setLayoutX(RecursosGlobales.getWidth());
        bkg22.setLayoutX(RecursosGlobales.getWidth());
        bkg33.setLayoutX(RecursosGlobales.getWidth());
        bkg44.setLayoutX(RecursosGlobales.getWidth());
    }

}
