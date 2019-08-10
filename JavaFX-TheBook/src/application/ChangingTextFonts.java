package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangingTextFonts extends Application{
	/**
	 * changing text font Listing 3-5
	 * @param args
	 */

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Changing Text");
		Group root = new Group();
		Scene scene = new Scene(root, 580,250,Color.WHITE);
		
		System.out.println("Font Families : ");
		Font.getFamilies()
		.stream()
		.forEach(i -> System.out.println(i));
		System.out.println("Font names:  ");
		Font.getFontNames()
		.stream()
		.forEach(i -> System.out.println(i));
		
		// Serif with drop shadow 
		Text text2 = new Text(50,50, "JavaFX 9 by example");
		Font serif = Font.font("Serif",30);
		text2.setFont(serif);
		text2.setFill(Color.RED);
		DropShadow dropshadow = new DropShadow();
		dropshadow.setOffsetX(2.0f);
		dropshadow.setOffsetY(2.0f);
		dropshadow.setColor(Color.rgb(50, 50, 50, .588));
		text2.setEffect(dropshadow);
		root.getChildren().add(text2);
		
		// SanSerif
		Text text3 = new Text(50,100, "JavaFX 9 by example");
		Font sanSerif = Font.font("SanSerif", 30);
		text3.setFont(sanSerif);
		text3.setFill(Color.BLUE);
		root.getChildren().add(text3);
		
		// Dialog
		Text text4 = new Text(50,150, "JavaFX 9 by example");
		Font dialogFont = Font.font("Dialog", 30);
		text3.setFont(dialogFont);
		text3.setFill(Color.GREEN);
		root.getChildren().add(text4);
		
		// Monospaced
		Text text5 = new Text(50,200, "JavaFX 9 by example");
		Font monoFont = Font.font("Monospaced", 30);
		text3.setFont(monoFont);
		text3.setFill(Color.BLACK);
		root.getChildren().add(text5);
		
		// Reflection
		Reflection ref = new Reflection();
		ref.setFraction(0.8f);
		ref.setTopOffset(5);
		text5.setEffect(ref);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
