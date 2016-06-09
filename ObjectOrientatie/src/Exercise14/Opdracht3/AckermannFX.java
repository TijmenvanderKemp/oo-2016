/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise14.Opdracht3;

import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Sjaak
 */
public class AckermannFX extends Application {

    Label resultLabel;
    AckermannTask solver = new AckermannTask (this) ;
    Thread t;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        
        
        primaryStage.setTitle("Ackermann");
        primaryStage.setScene( makeScene() );
        primaryStage.show();
    }

    private Scene makeScene() {
        Group root = new Group(  );
        
        GridPane g = new GridPane();
        g.setPadding(new Insets(6));
        
        g.add(new Label("Computing Ackermann"), 0, 0, 2, 1);
        g.add(new Label("m"), 0, 1);
        g.add(new Label("n"), 0, 2);
        g.add(new Label("result"), 0, 3);
        
        TextField mField = new TextField("0");
        TextField nField = new TextField("0");
        resultLabel = new Label("0");
        Button stopButton = new Button("stop");
        Button startButton = new Button("start");
        
        g.add(mField, 1, 1);
        g.add(nField, 1, 2);
        g.add(resultLabel, 1, 3);
        g.add(stopButton, 0, 4);
        g.add(startButton, 1, 4);
        
        root.getChildren().add(g);
        
        
        startButton.setOnAction((ActionEvent e) -> {
            // We have to create a new one because the old task lingered.
            // maybe not the prettiest way but it hard resets the previous Task
            solver = new AckermannTask (this) ;
            
            int m = 0, n = 0;
            try {
                m = Integer.parseInt(mField.getText());
            }
            catch (NumberFormatException nfe) {
                mField.setText("Not an integer!");
            }
            try {
                n = Integer.parseInt(nField.getText());
            }
            catch (NumberFormatException nfe) {
                nField.setText("Not an integer!");
            }
            solver.setInputs(m, n);
            t = new Thread(solver);
            t.setUncaughtExceptionHandler((Thread thread, Throwable exception) ->
                    System.out.println("The computation crashed! Did you run out of memory?"));
            t.setDaemon(true);
            t.start();
        });
        
        stopButton.setOnAction((ActionEvent e) -> {
            solver.cancel();
            
        });
        
        Scene scene = new Scene(root);
        return scene;
    }
    
    /**
     * 
     * @param labelText
     */
    public void setResultLabel (String labelText) {
        resultLabel.setText(labelText);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
