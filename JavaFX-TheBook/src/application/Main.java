package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Listing 3-1 
 * Drawing Lines 
 * @author HAC
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Drawing Lines");
		Group root = new Group(); // Group layout ..
		Scene scene = new Scene(root,300,150,Color.GRAY); // Dimension of window (300,150) and background color is gray
		
		// Red Line 
		Line redLine = new Line(10,10,200,10); // (startPointX, startPointY,EndPointX, EndPointY)
		
		// setting common properties 
		redLine.setStroke(Color.RED);
		redLine.setStrokeWidth(10);
		redLine.setStrokeLineCap(StrokeLineCap.BUTT);
		
		// creating a dashed pattern 
		redLine.getStrokeDashArray().addAll(10d,5d,15d,5d,20d);
		redLine.setStrokeDashOffset(0);
		
		// white line
		Line whiteLine = new Line(10,30,200,30); // (startPointX, startPointY,EndPointX, EndPointY)
		whiteLine.setStroke(Color.WHITE);
		whiteLine.setStrokeWidth(10);
		whiteLine.setStrokeLineCap(StrokeLineCap.ROUND);
		
		// Blue Line
		Line blueLine = new Line(10,50,200,50);
		blueLine.setStroke(Color.BLUE);
		blueLine.setStrokeWidth(10);
		
		
		
		// Adding Controls -- Slider with min,max, and current value 
		Slider slider = new Slider(0,100,0);
		slider.setLayoutX(10);
		slider.setLayoutY(95);
		
		//bind the stroke dash offset property 
		redLine.strokeDashOffsetProperty().bind(slider.valueProperty());
		
		Text offsetText  = new Text("Stroke Dash offset : " + slider.getValue());
		offsetText.setX(10);
		offsetText.setY(80);
		offsetText.setStroke(Color.WHITE);
		
		// display stroke dash offset value 
		slider.valueProperty().addListener((ov, curVal, newVal) -> offsetText.setText("Stroke Dash Offset: " + newVal));
		
		// Add All controls and nodes 
		root.getChildren().addAll(redLine,whiteLine,blueLine,slider,offsetText);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
