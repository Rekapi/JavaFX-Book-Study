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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * VBox Layout Example - Listing 5-2
 * @author HAC
 *
 */
public class VBoxExample extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		Group root  = new Group();
		Scene scene = new Scene(root,300,250);
		
		// pixels space between child nodes 
		VBox vbox = new VBox(5);
		
		// the border is blue, dashed, 0% radius for all corners , a width of 1 pixel
		BorderStroke[] borderStrokes = new BorderStroke[] { // To create a border, you have to create array of borderStroke objects
			new BorderStroke(Color.BLUE, BorderStrokeStyle.DASHED, new CornerRadii(0.0,true),new BorderWidths(1.0))	// you can replace it with DOTTED, SOLID or NONE
		};
		vbox.setBorder(new Border(borderStrokes));
		
		// padding between child nodes only
		vbox.setPadding(new Insets(1));
		
		// rectangles r1 to r4
		Rectangle r1 = new Rectangle(10,10);
		Rectangle r2 = new Rectangle(20,20);
		Rectangle r3 = new Rectangle(5,20);
		Rectangle r4 = new Rectangle(20,5);
		
		// margin of 2 pixels 
		VBox.setMargin(r1, new Insets(2,2,2,2));
		vbox.getChildren().addAll(r1,r2,r3,r4);
		
		root.getChildren().add(vbox);
		// once shown display the dimensions all added up.
		stage.setOnShown((WindowEvent we) -> {
			System.out.println("vbox width " + vbox.getBoundsInParent().getWidth());
			System.out.println("vbox height " + vbox.getBoundsInParent().getHeight());
		});
		stage.setTitle("VBox Example ");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
