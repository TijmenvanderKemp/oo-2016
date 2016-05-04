/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise11;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Main extends Application{

    @Override
    public void start(Stage stage)	{	
        GridPane grid =	new GridPane();	
	grid.setAlignment(Pos.CENTER);	
	grid.setHgap(5);	
	grid.setVgap(10);	
	Label heading =	new Label("Enter name and password");	
	heading.setFont(Font.font(18));	
	grid.add(heading, 0, 0,	2, 1);	
	grid.add(new Label("name"),0,1);	
	grid.add(new Label("Password"),0,2);	
	TextField nameField = new TextField("user");	
	TextField pwdField = new PasswordField();	
	pwdField.setTooltip(new	Tooltip("At least 1 letter"));	
	grid.add(nameField, 1, 1);	
	grid.add(pwdField, 1, 2);
        Label feedback = new Label("");	
	grid.add(feedback, 0, 4, 2, 1);	
	Button btn = new Button();	
	btn.setText("ok");	
	btn.setOnAction(e->{	
		String pwd1 = pwdField.getText();	
		String name = nameField.getText();	
        });
	grid.add(btn, 1, 3);	
	Scene scene = new Scene(grid, 300, 200);	
	stage.setTitle(this.getClass().getSimpleName());	
	stage.setScene(scene);	
	stage.show();	
        
    }
    
    public static void main (String [] args) {
        launch(args);
        //Controller controller = new Controller();
    }
    
}
