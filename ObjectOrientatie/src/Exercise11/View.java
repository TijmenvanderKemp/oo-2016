/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise11;

import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class View extends Application {
    
    Controller controller;
    List<String> gegevens = new LinkedList<>();
    
    @Override
    public void start(Stage stage)	{	
        controller = new Controller();
        for(int i = 0; i < 6; i++)
            gegevens.add("");
        
        GridPane grid =	new GridPane();	
	grid.setAlignment(Pos.CENTER);	
	grid.setHgap(5);	
	grid.setVgap(10);	
        
	Label heading =	new Label("Weather Forecast");	
	heading.setFont(Font.font(18));	
	grid.add(heading, 0, 0,	2, 1);	
        
        Button refreshButton = new Button();
        grid.add(refreshButton, 0, 1, 2, 1);
        refreshButton.setText("Refresh the data");
        refreshButton.setOnAction((ActionEvent e) -> {
            controller.refreshDocument();
        });  
        
	grid.add(new Label("Station:"),0,2);
        List<String> weerstations = controller.getWeerStations();
        ChoiceBox<String> choice = new ChoiceBox<>();	
	choice.getItems().addAll(weerstations);	
	choice.setValue(weerstations.get(0));
        grid.add(choice, 1, 2);
        // Implement dropdown
        
	Button stationButton = new Button();	
	stationButton.setText("Vraag gegevens op");	
	stationButton.setOnAction(new StationHandler());
	grid.add(stationButton, 1, 3);	
        
        grid.add(new Label("Datum:"), 0, 4);
        grid.add(new Label("Luchtvochtigheid:"), 0, 5);
        grid.add(new Label("Temperatuur (C):"), 0, 6);
        grid.add(new Label("Windsnelheid (bf):"), 0, 7);
        grid.add(new Label("Windrichting:"),0 , 8);
        grid.add(new Label("Regen (mm/h):"),0 , 9);
        
        grid.add(new Label(gegevens.get(2)), 1, 4);
        
        
	Scene scene = new Scene(grid, 300, 200);	
	stage.setTitle("Buienradar.nl");	
	stage.setScene(scene);	
	stage.show();	
        
    }
    
    private class StationHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            
        }
    }
    
    public static void main (String [] args) {
        launch(args);
    }
    
   
}
