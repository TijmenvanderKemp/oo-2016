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
                int n = getMandelgetal((double) i/800,(double) j/800);
                if(n % 2 == 1){
                    pixelWriter.setColor(i, j, Color.BLACK);
                }
                else{
                    pixelWriter.setColor(i, j, Color.WHITE);
                }
                //int colorIndex = i/5 * imageWith/5 + j/5;
                //pixelWriter.setColor(i, j, colorMap.getColor( colorIndex ));
            }               
        }
    }

    public double distanceTo0(double x, double y){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }

    public int getMandelgetal(double a, double b){
        int n = 0;
        double x = a;
        double y = b;
        while(distanceTo0(x,y) <= 2 && n <= MAX_ITERATIONS){
            x = Math.pow(x,2) - Math.pow(y,2) + a;
            y = 2 * x * y + b;
            n++;
        }
        return n;
    }
}
