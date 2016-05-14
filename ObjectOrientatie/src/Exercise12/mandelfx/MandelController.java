/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise12.mandelfx;

import Exercise12.mandelmodel.AreaFiller;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
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

    void beginRect(MouseEvent e) {
        rect[0] = e.getX();
        rect[1] = e.getY();
        e.consume();
    }

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
        
        parentFX.setTextFields(new String[] {
            String.valueOf(centerX),
            String.valueOf(centerY),
            String.valueOf(scale),
            String.valueOf(repetitions)
        });
    }
    
    void drag (double xLeft, double yUp, double xRight, double yDown) {
        centerX = ((xLeft + xRight) / 2 - gridWidth/2) / scale;
        centerY = ((yUp + yDown) / 2 - gridHeight/2) / scale;
        
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
