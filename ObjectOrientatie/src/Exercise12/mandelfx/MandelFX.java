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
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Sjaak
 */
public class MandelFX extends Application {

    public static final int GRID_WIDTH = 800, GRID_HEIGHT = 800;    
    private Canvas canvas;
    private MandelController mandelController;
    
    @Override
    public void start(Stage primaryStage) {
        mandelController = new MandelController(this);
        primaryStage.setTitle("Mandelbrot");
        primaryStage.setScene( makeScene() );
        primaryStage.show();
    }

    private Scene makeScene() {
        canvas = new Canvas(GRID_WIDTH, GRID_HEIGHT);
        AreaFiller areaFiller = new AreaFiller(  );

        areaFiller.fill( canvas );

        Group root = new Group( canvas );
        
        GridPane g = new GridPane();
        
        g.add(new Label("Center (x, y):"), 0, 0);
        g.add(new Label("Scale:"), 0, 1);
        g.add(new Label("Repetitions:"), 0, 2);
        
        TextField centerXTextField = new TextField("0");
        TextField centerYTextField = new TextField("0");
        TextField scaleTextField = new TextField("100");
        TextField repetitionsTextField = new TextField("20");
        Button enterDataButton = new Button("Draw the fractal!");
        
        g.add(centerXTextField, 1, 0);
        g.add(centerYTextField, 2, 0);
        g.add(scaleTextField, 1, 1, 2, 1);
        g.add(repetitionsTextField, 1, 2, 2, 1);
        g.add(enterDataButton, 0, 3, 3, 1);
        
        root.getChildren().add(g);
        
        enterDataButton.setOnAction((ActionEvent e) -> 
            mandelController.dataEntered(new String[]{
                centerXTextField.getText(),
                centerYTextField.getText(),
                scaleTextField.getText(),
                repetitionsTextField.getText()
            })
        );
        
        // Fire the button to draw the fractal for the first time
        enterDataButton.fire();
        
        Scene scene = new Scene(root);
        return scene;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
