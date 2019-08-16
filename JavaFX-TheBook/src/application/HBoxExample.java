package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * HBox Layout Example - Listing 5-1
 * @author HAC
 *
 */
public class HBoxExample extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		Group root  = new Group();
		Scene scene = new Scene(root,300,250);
		
		// pixels space between child nodes 
		HBox hbox = new HBox(5);
		
		// the border is blue, dashed, 0% radius for all corners , a width of 1 pixel
		BorderStroke[] borderStrokes = new BorderStroke[] { // To create a border, you have to create array of borderStroke objects
			new BorderStroke(Color.BLUE, BorderStrokeStyle.DASHED, new CornerRadii(0.0,true),new BorderWidths(1.0))	// you can replace it with DOTTED, SOLID or NONE
		};
		hbox.setBorder(new Border(borderStrokes));
		
		// padding between child nodes only
		hbox.setPadding(new Insets(1));
		
		// rectangles r1 to r4
		Rectangle r1 = new Rectangle(10,10);
		Rectangle r2 = new Rectangle(20,20);
		Rectangle r3 = new Rectangle(5,20);
		Rectangle r4 = new Rectangle(20,5);
		
		// margin of 2 pixels 
		HBox.setMargin(r1, new Insets(2,2,2,2));
		hbox.getChildren().addAll(r1,r2,r3,r4);
		
		root.getChildren().add(hbox);
		// once shown display the dimensions all added up.
		stage.setOnShown((WindowEvent we) -> {
			System.out.println("hbox width " + hbox.getBoundsInParent().getWidth());
			System.out.println("hbox height " + hbox.getBoundsInParent().getHeight());
		});
		stage.setTitle("HBox Example ");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
