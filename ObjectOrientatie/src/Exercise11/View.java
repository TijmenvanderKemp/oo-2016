/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise11;

import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
    @Override
    public void start(Stage stage)	{	
        controller = new Controller();
        
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
        // Implement dropdown
        
	Button stationButton = new Button();	
	stationButton.setText("ok");	
	stationButton.setOnAction(e->{	
		controller.getInfoAboutStation("Arnhem"); // CHANGE THIS TO RELEVANT THING
        });
	grid.add(stationButton, 1, 3);	
        
	Scene scene = new Scene(grid, 300, 200);	
	stage.setTitle("Buienradar.nl");	
	stage.setScene(scene);	
	stage.show();	
        
    }
    
    public static void main (String [] args) {
        launch(args);
    }
    
}
