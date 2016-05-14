/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise12.mandelfx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import Exercise12.mandelmodel.AreaFiller;

/**
 *
 * @author Sjaak
 */
public class MandelFX extends Application {

    public static final int GRID_WIDTH = 800, GRID_HEIGHT = 800;    
    private Canvas canvas;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mandelbrot");
        primaryStage.setScene( makeScene() );
        primaryStage.show();
    }

    private Scene makeScene() {
        canvas = new Canvas(GRID_WIDTH, GRID_HEIGHT);
        AreaFiller areaFiller = new AreaFiller(  );

        areaFiller.fill( canvas );

        Group root = new Group( canvas );
        Scene scene = new Scene(root);
        return scene;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
