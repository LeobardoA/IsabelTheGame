/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import com.jfoenix.controls.JFXSlider;
import isabelthegame.RecursosGlobales;
import java.awt.Toolkit;
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
import javafx.scene.control.Label;
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
public class OptionsController implements Initializable {

    @FXML
    private Label resolution;
    @FXML
    private ImageView bkg00;
    @FXML
    private ImageView bkg0;
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
    private Timeline timeline0, timeline1, timeline2, timeline3;
    private KeyValue value0, value1, value2, value3, value4, value5, value6, value7;
    private KeyFrame frame0, frame1, frame2, frame3;
    private final String[] resolutions = {"800x550", "1200x825", "1600x1100", "Full Screen"};
    private byte resId = 0;
    @FXML
    private JFXSlider sldVolume;
    @FXML
    private AnchorPane padre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        applyResolutions();
        backgroundMovement();
        String cadena = (int) RecursosGlobales.getWidth() + "x" + (int) RecursosGlobales.getHeight();
        if (cadena.equals(resolutions[0])) {
            resId = 0;
        } else if (cadena.equals(resolutions[1])) {
            resId = 1;
        } else if (cadena.equals(resolutions[2])) {
            resId = 2;
        } else {
            resId = 3;
        }
        resolution.setText(resolutions[resId]);
        sldVolume.setValue(RecursosGlobales.getVolume() * 100);
        sldVolume.valueProperty().addListener((observable) -> {
            RecursosGlobales.setVolume((sldVolume.getValue()) / 100);
        });
    }

    @FXML
    private void lessRes(ActionEvent event) {
        if (resId == 0) {
            resId = 3;
            resolution.setText(resolutions[resId]);
        } else {
            resId--;
            resolution.setText(resolutions[resId]);
        }
        applyResolution();
    }

    @FXML
    private void plusRes(ActionEvent event) {
        if (resId == 3) {
            resId = 0;
            resolution.setText(resolutions[resId]);
        } else {
            resId++;
            resolution.setText(resolutions[resId]);
        }
        applyResolution();
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

    private void backgroundMovement() {
        value0 = new KeyValue(bkg0.translateXProperty(), -RecursosGlobales.getWidth());
        value1 = new KeyValue(bkg00.translateXProperty(), -RecursosGlobales.getWidth());
        value2 = new KeyValue(bkg1.translateXProperty(), -RecursosGlobales.getWidth());
        value3 = new KeyValue(bkg11.translateXProperty(), -RecursosGlobales.getWidth());
        value4 = new KeyValue(bkg2.translateXProperty(), -RecursosGlobales.getWidth());
        value5 = new KeyValue(bkg22.translateXProperty(), -RecursosGlobales.getWidth());
        value6 = new KeyValue(bkg3.translateXProperty(), -RecursosGlobales.getWidth());
        value7 = new KeyValue(bkg33.translateXProperty(), -RecursosGlobales.getWidth());

        frame0 = new KeyFrame(Duration.seconds(40), value0, value1);
        frame1 = new KeyFrame(Duration.seconds(16), value2, value3);
        frame2 = new KeyFrame(Duration.seconds(20), value4, value5);
        frame3 = new KeyFrame(Duration.seconds(12), value6, value7);

        timeline0 = new Timeline();
        timeline0.setCycleCount(Timeline.INDEFINITE);
        timeline0.getKeyFrames().add(frame0);
        timeline0.play();

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
    }

    private void applyResolution() {
        if (resId < 3) {
            RecursosGlobales.setWidth(Double.parseDouble(resolutions[resId].split("x")[0]));
            RecursosGlobales.setHeight(Double.parseDouble(resolutions[resId].split("x")[1]));
            RecursosGlobales.setFullSize(false);
        } else {
            Toolkit tk = Toolkit.getDefaultToolkit();
            RecursosGlobales.setWidth(tk.getScreenSize().width);
            RecursosGlobales.setHeight(tk.getScreenSize().height);
            RecursosGlobales.setFullSize(true);
        }
    }

    private void applyResolutions() {
        padre.setPrefSize(RecursosGlobales.getWidth(), RecursosGlobales.getHeight());

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

        bkg00.setLayoutX(RecursosGlobales.getWidth());
        bkg11.setLayoutX(RecursosGlobales.getWidth());
        bkg22.setLayoutX(RecursosGlobales.getWidth());
        bkg33.setLayoutX(RecursosGlobales.getWidth());

    }
}
