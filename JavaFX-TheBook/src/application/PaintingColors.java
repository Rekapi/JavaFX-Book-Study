package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PaintingColors extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Painting Colors ");
		Group root = new Group();
		Scene scene =  new Scene(root,350,300,Color.WHITE);
		
		// Red ellipse with radial gradient color 
		Ellipse ellipse = new Ellipse(100, //center x
				50+ 70/2, /* center Y */
				50, /* radius X */
				70/2); /* radius Y */
		RadialGradient gradient1 = new RadialGradient(
				0, /* focusAngle */ 
				.1, /* focusDistance */ 
				80, /* centerX */
				45, /* centerY */
				120, /* radius */
				false, /* proportional */
				CycleMethod.NO_CYCLE, /* cycleMethod*/ 
				new Stop(0, Color.RED), /*Stops */
				new Stop(1, Color.BLACK));
		ellipse.setFill(gradient1);
		root.getChildren().add(ellipse);
		double ellipseHeight = ellipse.getBoundsInParent().getHeight();
		
		// thick black line behind second shape
		Line blackLine = new Line();
		blackLine.setStartX(170);
		blackLine.setStartY(30);
		blackLine.setEndX(20);
		blackLine.setEndY(140);
		blackLine.setFill(Color.BLACK);
		blackLine.setStrokeWidth(10.0f);
		blackLine.setTranslateY(ellipseHeight + 10);
		root.getChildren().add(blackLine);
		
		// rectangle filled with a linear gradient with a translucent color 
		Rectangle rec = new Rectangle();
		rec.setX(50);
		rec.setY(50);
		rec.setWidth(100);
		rec.setHeight(70);
		rec.setTranslateY(ellipseHeight + 10);
		
		LinearGradient linearGrad = new LinearGradient(
				0, /* start X*/
				0, /* start Y */
				0, /* end X */
				1, /* end Y */ 
				true, /* proportional */ 
				CycleMethod.NO_CYCLE, /* cycle color stops */ 
				new Stop(0.1f, Color.rgb(255,200,0, .784)),
				new Stop(1.0f, Color.rgb(0, 0, 0, .784)));
		rec.setFill(linearGrad);
		root.getChildren().add(rec);
		
		// rectangle filled with a linear gradient with reflective cycle 
		Rectangle roundrec = new Rectangle();
		roundrec.setX(50);
		roundrec.setY(50);
		roundrec.setWidth(100);
		roundrec.setHeight(70);
		roundrec.setArcHeight(20);
		roundrec.setTranslateY(ellipseHeight + 10 + rec.getHeight() + 10);
		
		LinearGradient cycleGrad = new LinearGradient(
				0, /* start X*/
				0, /* start Y */
				0, /* end X */
				1, /* end Y */ 
				true, /* proportional */ 
				CycleMethod.REFLECT, /* cycle methods */ 
				new Stop(0f, Color.rgb(0,255,0, .784)),
				new Stop(1.0f, Color.rgb(0, 0, 0, .784)));
		roundrec.setFill(cycleGrad);
		root.getChildren().add(roundrec);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
