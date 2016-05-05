/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise11;

import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
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
    String choiceOnChoiceBox;
    List<String> gegevens = new LinkedList<>();
    
    @Override
    public void start(Stage stage)	{	
        controller = new Controller();
        for(int i = 0; i < 14; i++)
            gegevens.add("");
        
        GridPane grid =	new GridPane();	
	grid.setAlignment(Pos.CENTER);	
	grid.setHgap(5);	
	grid.setVgap(10);	
        
        // The title label at the top
	Label heading =	new Label("Weather Forecast");	
	heading.setFont(Font.font(18));	
	grid.add(heading, 0, 0,	2, 1);	
        
        // The button to refresh the data
        Button refreshButton = new Button();
        grid.add(refreshButton, 0, 1, 2, 1);
        refreshButton.setText("Refresh the data");
        refreshButton.setOnAction((ActionEvent e) -> {
            controller.refreshDocument();
        });  
        
        // The dropdown with all the stations
	grid.add(new Label("Station:"),0,2);
        List<String> weerstations = controller.getWeerStations();
        ChoiceBox<String> choice = new ChoiceBox<>();	
	choice.getItems().addAll(weerstations);	
	choice.setValue(weerstations.get(0));
        grid.add(choice, 1, 2);
        
        // Using StringProperty to update the Labels automatically
        StringProperty pDatum = new SimpleStringProperty();
	StringProperty pLuchtV = new SimpleStringProperty();
	StringProperty pTemp = new SimpleStringProperty();
	StringProperty pWindS = new SimpleStringProperty();
	StringProperty pWindR = new SimpleStringProperty();
	StringProperty pRegen = new SimpleStringProperty();
        
        grid.add(new Label("Datum:"), 0, 4);
        grid.add(new Label("Luchtvochtigheid:"), 0, 5);
        grid.add(new Label("Temperatuur (C):"), 0, 6);
        grid.add(new Label("Windsnelheid (bf):"), 0, 7);
        grid.add(new Label("Windrichting:"),0 , 8);
        grid.add(new Label("Regen (mm/h):"),0 , 9);
        grid.add(new Label("Visuele referentie:"), 0, 10);
        
        Label gDatum = new Label("");
        Label gLuchtV = new Label("");
        Label gTemp = new Label("");
        Label gWindS = new Label("");
        Label gWindR = new Label("");
        Label gRegen = new Label("");
        
        gDatum.textProperty().bind(pDatum);
        gLuchtV.textProperty().bind(pLuchtV);
        gTemp.textProperty().bind(pTemp);
        gWindS.textProperty().bind(pWindS);
        gWindR.textProperty().bind(pWindR);
        gRegen.textProperty().bind(pRegen);
        
        grid.add(gDatum, 1, 4);
        grid.add(gLuchtV, 1, 5);
        grid.add(gTemp, 1, 6);
        grid.add(gWindS, 1, 7);
        grid.add(gWindR, 1, 8);
        grid.add(gRegen, 1, 9);
        
        // Create the icon and save the group.
        Group iconGroup = createIcon("http://xml.buienradar.nl/icons/a.gif", grid);
        
        // The button to request the data per station.
        Button stationButton = new Button();	
	stationButton.setText("Vraag gegevens op");	
	stationButton.setOnAction((ActionEvent ae) -> {
            gegevens = controller.getInfoAboutStation(choice.getValue());
            pDatum.setValue(gegevens.get(2));
            pLuchtV.setValue(gegevens.get(3));
            pTemp.setValue(gegevens.get(4));
            pWindS.setValue(gegevens.get(6));
            pWindR.setValue(gegevens.get(8));
            pRegen.setValue(gegevens.get(12));
            ( (ImageView) iconGroup.getChildren().get(0) )
                    .setImage(new Image(gegevens.get(13)));
        });
        // Update for the first choice in the list.
        stationButton.fire();
	grid.add(stationButton, 1, 3);
        
	Scene scene = new Scene(grid, 300, 340);	
	stage.setTitle("Buienradar.nl");	
	stage.setScene(scene);	
	stage.show();
    }
    
    private Group createIcon (String url, GridPane grid) {
        
        String imageSource = url;
         
        ImageView imageView = ImageViewBuilder.create()
                .image(new Image(imageSource))
                .build();
         
        Group myGroup = GroupBuilder.create()
                .children(imageView)
                .build();
        
        
        grid.add(myGroup, 1, 10);
        
        return myGroup;
    }
    
    private Group updateIcon (String url, Group iconGroup) {
        ImageView iconImageView = (ImageView) iconGroup.getChildren().get(0);
        iconImageView.setImage(new Image(url));
        return iconGroup;
    }
    
    public static void main (String [] args) {
        launch(args);
    }
    
   
}
