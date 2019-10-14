/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isabelthegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author avile
 */
public class IsabelTheGame extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/Diseños/Menu.fxml"));
        
        Scene scene = new Scene(root);
        RecursosGlobales.play();
        RecursosGlobales.setVolume(1);
        
        stage.setScene(scene);
        stage.setMaxWidth(RecursosGlobales.getWidth());
        stage.setMaxHeight(RecursosGlobales.getHeight());
        stage.setMinWidth(RecursosGlobales.getWidth());
        stage.setMinHeight(RecursosGlobales.getHeight());
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
