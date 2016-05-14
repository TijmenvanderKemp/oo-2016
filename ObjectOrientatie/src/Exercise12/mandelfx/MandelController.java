/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise12.mandelfx;

import Exercise12.mandelmodel.AreaFiller;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author tijmen
 */
public class MandelController {
    
    private final MandelFX parentFX;
    private final AreaFiller areaFiller;
    
    Canvas canvas;
    double gridWidth;
    double gridHeight;
    double centerX;
    double centerY;
    double scale;
    double repetitions;
    
    double [] rect;
    
    public MandelController (MandelFX parent) {
        parentFX = parent;
        areaFiller = new AreaFiller(  );
        rect = new double[4];
    }
    
    /**
     * When the button is clicked, this function calls the AreaFiller to 
     * draw the fractal with the values provided in the TextFields.
     * @param canvas the canvas to draw the fractal on
     * @param data the data to draw with
     */
    public void dataEntered (Canvas canvas, String [] data) {
        this.canvas = canvas;
        gridWidth = canvas.getWidth();
        gridHeight = canvas.getHeight();
        centerX = Double.parseDouble(data[0]);
        centerY = Double.parseDouble(data[1]);
        scale = Double.parseDouble(data[2]);
        repetitions = Double.parseDouble(data[3]);
        areaFiller.fill( canvas, centerX, centerY, scale, repetitions );
    }

    /**
     * Stores the beginning of the area that the user wants to zoom in on.
     * @param e
     * @return A Rectangle object on that location for drawing.
     */
    Rectangle beginRect(MouseEvent e) {
        rect[0] = e.getX();
        rect[1] = e.getY();
        Rectangle rectangle = new Rectangle (rect[0], rect[1], 10, 10);
        rectangle.setFill(new Color(1.0f, 0.0f, 0.0f, 0.5f));
        rectangle.setStroke(new Color(1.0f, 0.0f, 0.0f, 1.0f));
        
        
        e.consume();
        
        Rectangle newRect = new Rectangle (rect[0], rect[1], 10, 10);
        newRect.setFill(new Color(1, 0, 0, 0.5));
        newRect.setStroke(new Color(1, 0, 0, 1));
        
        return newRect;
    }

    /**
     * Zooms in on the selected rectangle.
     * @param e 
     */
    void finishRect(MouseEvent e) {
        rect[2] = e.getX();
        rect[3] = e.getY();
        
        // If the begin X and end X are too close (same for Y)
        // assume that the user clicked instead of dragged
        if (Math.abs(rect[0] - rect[2]) <= 5 ||
            Math.abs(rect[1] - rect[3]) <= 5) {
            clickZoom(rect[0], rect[1], !e.isShiftDown());
        }
        else {
            drag(rect[0], rect[1], rect[2], rect[3]);
        }
        e.consume();
    }
    
    /**
     * Zooms in or out on the selected point.
     * @param x of the point to zoom on
     * @param y of the point to zoom on
     * @param in whether to zoom in or out
     */
    void clickZoom (double x, double y, boolean in) {
        centerX = (x - gridWidth/2) / scale + centerX;
        centerY = (y - gridHeight/2) / scale + centerY;
        if (in) {
            scale *= 2;
        }
        else {
            scale /= 2;
        }
        
        areaFiller.fill( canvas, centerX, centerY, scale, repetitions );
        
        // Update the TextFields to represent the new values
        parentFX.setTextFields(new String[] {
            String.valueOf(centerX),
            String.valueOf(centerY),
            String.valueOf(scale),
            String.valueOf(repetitions)
        });
    }
    
    /**
     * Zooms in on the selected rectangle. Similar to the point zoom,
     * just minor differences in the center and scale calculation.
     * @param xLeft
     * @param yUp
     * @param xRight
     * @param yDown 
     */
    void drag (double xLeft, double yUp, double xRight, double yDown) {
        centerX = ((xLeft + xRight) / 2 - gridWidth/2) / scale + centerX;
        centerY = ((yUp + yDown) / 2 - gridHeight/2) / scale + centerY;
        
        double largerSide = Math.max(Math.abs(xRight - xLeft), 
                                     Math.abs(yDown - yUp));
        scale = scale * gridWidth / largerSide;
        
        areaFiller.fill( canvas, centerX, centerY, scale, repetitions );
        
        parentFX.setTextFields(new String[] {
            String.valueOf(centerX),
            String.valueOf(centerY),
            String.valueOf(scale),
            String.valueOf(repetitions)
        });
    }

}
