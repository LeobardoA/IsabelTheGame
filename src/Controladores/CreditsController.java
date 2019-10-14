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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author avile
 */
public class CreditsController implements Initializable {

    @FXML
    private ImageView bkg0;
    @FXML
    private ImageView bkg00;
    @FXML
    private ImageView bkg1;
    @FXML
    private ImageView bkg11;
    @FXML
    private ImageView bkg2;
    @FXML
    private ImageView bkg22;
    @FXML
    private ImageView bkg3;
    @FXML
    private ImageView bkg33;
    @FXML
    private ImageView bkg4;
    @FXML
    private ImageView bkg44;
    @FXML
    private AnchorPane padre;
    private KeyValue value0, value1, value2, value3, value4, value5, value6;
    private KeyValue value7, value8, value9;
    private KeyFrame frame0, frame1, frame2, frame3, frame4;
    private Timeline timeline1, timeline2, timeline3, timeline4, timeline5;
    @FXML
    private ImageView fondo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        applyResolutions();
        backgroundMovement();
    }

    private void backgroundMovement() {
        value0 = new KeyValue(bkg0.translateXProperty(), -RecursosGlobales.getWidth());
        value1 = new KeyValue(bkg0.translateXProperty(), -RecursosGlobales.getWidth());
        value2 = new KeyValue(bkg1.translateXProperty(), -RecursosGlobales.getWidth());
        value3 = new KeyValue(bkg11.translateXProperty(), -RecursosGlobales.getWidth());
        value4 = new KeyValue(bkg2.translateXProperty(), -RecursosGlobales.getWidth());
        value5 = new KeyValue(bkg22.translateXProperty(), -RecursosGlobales.getWidth());
        value6 = new KeyValue(bkg3.translateXProperty(), -RecursosGlobales.getWidth());
        value7 = new KeyValue(bkg33.translateXProperty(), -RecursosGlobales.getWidth());
        value8 = new KeyValue(bkg4.translateXProperty(), -RecursosGlobales.getWidth());
        value9 = new KeyValue(bkg44.translateXProperty(), -RecursosGlobales.getWidth());

        frame0 = new KeyFrame(Duration.seconds(45), value0, value1);
        frame1 = new KeyFrame(Duration.seconds(40), value2, value3);
        frame2 = new KeyFrame(Duration.seconds(30), value4, value5);
        frame3 = new KeyFrame(Duration.seconds(25), value6, value7);
        frame4 = new KeyFrame(Duration.seconds(18), value8, value9);

        timeline1 = new Timeline();
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.getKeyFrames().add(frame0);
        timeline1.play();
        
        timeline2 = new Timeline();
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.getKeyFrames().add(frame1);
        timeline2.play();
        
        timeline3 = new Timeline();
        timeline3.setCycleCount(Timeline.INDEFINITE);
        timeline3.getKeyFrames().add(frame2);
        timeline3.play();
        
        timeline4 = new Timeline();
        timeline4.setCycleCount(Timeline.INDEFINITE);
        timeline4.getKeyFrames().add(frame3);
        timeline4.play();
        
        timeline5 = new Timeline();
        timeline5.setCycleCount(Timeline.INDEFINITE);
        timeline5.getKeyFrames().add(frame4);
        timeline5.play();

    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Stage stage = new Stage(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/Diseños/Menu.fxml"));
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
    private void important(MouseEvent event) throws IOException {
        Stage stage = new Stage(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/Diseños/Importante.fxml"));
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
        bkg0.getScene().getWindow().hide();
    }

    private void applyResolutions() {
        padre.setPrefSize(RecursosGlobales.getWidth(), RecursosGlobales.getHeight());

        fondo.setFitWidth(RecursosGlobales.getWidth());
        fondo.setFitHeight(RecursosGlobales.getHeight());

        bkg0.setFitWidth(RecursosGlobales.getWidth());
        bkg0.setFitHeight(RecursosGlobales.getHeight());

        bkg00.setFitWidth(RecursosGlobales.getWidth());
        bkg00.setFitHeight(RecursosGlobales.getHeight());

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

        bkg00.setLayoutX(RecursosGlobales.getWidth());
        bkg11.setLayoutX(RecursosGlobales.getWidth());
        bkg22.setLayoutX(RecursosGlobales.getWidth());
        bkg33.setLayoutX(RecursosGlobales.getWidth());
        bkg44.setLayoutX(RecursosGlobales.getWidth());
    }

}
