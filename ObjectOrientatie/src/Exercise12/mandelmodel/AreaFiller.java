/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise12.mandelmodel;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;

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
     * @param canvas canvas dat gevuld moet worden
     * @param centerX x-coordinaat van het midden van het canvas
     * @param centerY y-coordinaat van het midden van het canvas
     * @param scale de schaal hoe ver is ingezoomd op het canvas
     * @param repetition na hoeveel pogingen we aannemen dat een mandelgetal oneindig is.
     */
    public void fill( Canvas canvas, 
                      double centerX, 
                      double centerY, 
                      double scale,
                      double repetition ) {
        
        // Hard cap the repetition number at 1000, so users dont fry their computer
        repetition = Math.min(repetition, 1000);
        
        // Get the image dimensions from the canvas so the class can draw
        int imageWidth   = (int) canvas.getWidth();
        int imageHeight = (int) canvas.getHeight();
        
        // Make it so a bigger scale actually zooms in
        scale = imageWidth / scale;
        
        final PixelWriter pixelWriter = canvas.getGraphicsContext2D().getPixelWriter();
        for (int i = 0; i < imageWidth; i++) {
            for (int j = 0; j < imageHeight; j++) {
                // i/imageWidth is between 0 and 1.
                // First make sure it's between -0.5 and 0.5, then scale it, then offset it
                int n = getMandelgetal(((double) i/imageWidth - 0.5) * scale + centerX,
                                       ((double) j/imageHeight - 0.5) * scale + centerY, 
                                       repetition);
                pixelWriter.setColor(i, j, colorMap.getColor(n));
                /**if(n % 2 == 0){
                    pixelWriter.setColor(i, j, Color.BLACK);
                }
                else{
                    pixelWriter.setColor(i, j, Color.WHITE);
                }*/
                //int colorIndex = i/5 * imageWith/5 + j/5;
                //pixelWriter.setColor(i, j, colorMap.getColor( colorIndex ));
            }               
        }
    }

    /**
     * berekent de afstand van een punt tot (0,0)
     * @param x x-coordinaat van het punt
     * @param y y-coordinaat van het punt
     * @return  de afstand
     */
    public double distanceTo0(double x, double y){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }

    /**
     * geeft het mandelgetal van een punt
     * @param a x-coordinaat van het punt
     * @param b y-coordinaat
     * @param repetitions het aantal repitions waarna we aannemen dat het mandelgetal oneindig is
     * @return Het mandelgetal van het punt, geeft repetitions als het mandelgetal oneindig zou zijn
     */
    public int getMandelgetal(double a, double b, double repetitions){
        int n = 0;
        double x = a;
        double y = b;
        while(distanceTo0(x,y) <= 2 && n <= repetitions){
            double xNew = Math.pow(x,2) - Math.pow(y,2) + a;
            double yNew = 2 * x * y + b;
            x = xNew;
            y = yNew;
            n++;
        }
        return n;
        /**if(n == repetitions + 1){
            return 0;
        }
        else
            return n;
        */
    }
}
