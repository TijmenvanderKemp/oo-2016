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

    public double distanceTo0(double x, double y){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }

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
