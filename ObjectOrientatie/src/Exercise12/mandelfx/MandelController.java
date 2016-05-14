/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise12.mandelfx;

import Exercise12.mandelmodel.AreaFiller;
import javafx.scene.canvas.Canvas;

/**
 *
 * @author tijmen
 */
public class MandelController {
    
    private final MandelFX parentFX;
    private final AreaFiller areaFiller;
    
    public MandelController (MandelFX parent) {
        parentFX = parent;
        areaFiller = new AreaFiller(  );

    }
    
    public void dataEntered (Canvas canvas, String [] data) {
        double centerX = Double.parseDouble(data[0]);
        double centerY = Double.parseDouble(data[1]);
        double scale = Double.parseDouble(data[2]);
        double repetitions = Double.parseDouble(data[3]);
        areaFiller.fill( canvas, centerX, centerY, scale, repetitions );
    }
}
