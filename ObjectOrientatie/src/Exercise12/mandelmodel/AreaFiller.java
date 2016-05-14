/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise12.mandelmodel;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * A skeleton class illustrating the use of a pixelWriter
 * 
 * @author Sjaak Smetsers
 * @version 06-05-2016
 */
public class AreaFiller {

    public static final int MAX_ITERATIONS = 20;

    private static final ColorMap colorMap = new ColorMap( MAX_ITERATIONS );

    /**
     * fills the canvas with some arbitrarily chosen pattern
     */
    public void fill( Canvas canvas ) {
        int imageWith   = (int) canvas.getWidth();
        int imageHeight = (int) canvas.getHeight();
        final PixelWriter pixelWriter = canvas.getGraphicsContext2D().getPixelWriter();
        for (int i = 0; i < imageWith; i++) {
            for (int j = 0; j < imageHeight; j++) {
                int colorIndex = i/5 * imageWith/5 + j/5;
                pixelWriter.setColor(i, j, colorMap.getColor( colorIndex ));
            }               
        }
    }    

}
