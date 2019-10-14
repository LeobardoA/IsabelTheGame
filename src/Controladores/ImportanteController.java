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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author avile
 */
public class ImportanteController implements Initializable {

    @FXML
    private Label lbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void regresar(MouseEvent event) throws IOException {
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
        lbl.getScene().getWindow().hide();
    }

}
