/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isabelthegame;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author avile
 */
public class RecursosGlobales {

    private static double width = 800, height = 550;
    private static boolean sound = true, fullSize = false;
    private static final Media media = new Media(RecursosGlobales.class.getResource("/Recursos/song.mp3").toExternalForm());
    private static MediaPlayer player = new MediaPlayer(media);

    public static boolean isSound() {
        return sound;
    }

    public static void setSoundValue(boolean sound) {
        RecursosGlobales.sound = sound;
    }

    public static void play() {
        player.play();
    }

    public static void pause() {
        player.pause();
    }

    public static void setVolume(double volume) {
        player.setVolume(volume);
    }

    public static double getVolume() {
        return player.getVolume();
    }

    public static double getWidth() {
        return width;
    }

    public static void setWidth(double width) {
        RecursosGlobales.width = width;
    }

    public static double getHeight() {
        return height;
    }

    public static void setHeight(double height) {
        RecursosGlobales.height = height;
    }

    public static MediaPlayer getPlayer() {
        return player;
    }

    public static void setPlayer(MediaPlayer player) {
        RecursosGlobales.player = player;
    }

    public static boolean isFullSize() {
        return fullSize;
    }

    public static void setFullSize(boolean fullSize) {
        RecursosGlobales.fullSize = fullSize;
    }

    
    
}
