package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Chapter 4 - Listing 4-34
 * Form validation - Login form using lambdas, properties and bindings 
 * @author HAC
 *
 */
public class FormValidation extends Application{
	
	// declaring some variables 
	private final static String MY_PASS = "password1";
	private final static BooleanProperty GRANTED_ACCESS = new SimpleBooleanProperty();
	private final static int MAX_ATTEMPTS = 3;
	private final IntegerProperty ATTEMPTS = new SimpleIntegerProperty();
	
	@Override
	public void start(Stage stage) throws Exception {
		// create a domain model representing a user 
		User user = new User();
		
		// create a transparent stage 
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setAlwaysOnTop(true);
		
		Group root = new Group();
		Scene scene = new Scene(root,320,112,null);
		
		// load style.css to style JavaFX nodes
		scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
		stage.setScene(scene);
		
		// rounded rectangular background
		Rectangle background = new Rectangle();
		background.setId("background-rect");
		background.widthProperty().bind(scene.widthProperty().subtract(5)); // width of the rect = scene width - 5
		background.heightProperty().bind(scene.heightProperty().subtract(5)); // height of the rect = scene height - 5
		
		// a read only field holding the user name 
		Label userName = new Label();
		userName.setId("username");
		userName.textProperty().bind(user.userNameProperty());
		
		HBox userNameCell = new HBox();
		userNameCell.getChildren().add(userName);
		
		// when Label's text is wider than the background minus the padlock icon
		userNameCell.maxWidthProperty().bind(stage.widthProperty().subtract(45));
		userNameCell.prefWidthProperty().bind(stage.widthProperty().subtract(45));
		
		// padlock
		Region padlock = new Region();
		padlock.setId("padlock");
		
		HBox padlockCell = new HBox();
		padlockCell.setId("padlockCell");
		HBox.setHgrow(padlockCell, Priority.ALWAYS);
		padlockCell.getChildren().add(padlock);
		
		// first row 
		HBox row1 = new HBox();
		row1.getChildren().addAll(userNameCell, padlockCell);
		
		// password text field 
		PasswordField passwordField = new PasswordField();
		passwordField.setId("password-field");
		passwordField.setPromptText("Password");
		passwordField.prefWidthProperty().bind(stage.widthProperty().subtract(55));
		// populate user object's password from password field 
		user.passwordProperty().bind(passwordField.textProperty());
		
		// error icon 
		Region deniedIcon = new Region();
		deniedIcon.setId("denied-icon");
		deniedIcon.setVisible(true);
		
		// granted icon 
		Region grantedIcon = new Region();
		grantedIcon.setId("granted-icon");
		grantedIcon.visibleProperty().bind(GRANTED_ACCESS);
		
		// hide and show denied icon and granted icon 
		StackPane accesIndicator = new StackPane();
		accesIndicator.getChildren().addAll(deniedIcon, grantedIcon);
		
		// second Row
		HBox row2 = new HBox(3);
		row2.getChildren().addAll(passwordField, accesIndicator);
		HBox.setHgrow(accesIndicator, Priority.ALWAYS);
		
		// user hits the enter key on the password field 
		passwordField.setOnAction(actionEvent -> {
			if(GRANTED_ACCESS.get()) {
				System.out.printf("User %s is granted access. \n",user.getUserName());
				System.out.printf("User %s entered the password : %s\n", user.getUserName(),user.getPassword());
				Platform.exit();
			}else {
				deniedIcon.setVisible(true);
				ATTEMPTS.set(ATTEMPTS.add(1).get());
			}
		});
		
		// listener when the user types into the password field
		passwordField.textProperty().addListener((obs, ov, nv) -> {
			GRANTED_ACCESS.set(passwordField.getText().equals(MY_PASS));
			if(GRANTED_ACCESS.get()) {
				deniedIcon.setVisible(false);
			}
		});
		
		// listener on number of attempts 
		ATTEMPTS.addListener((obs, ov, nv) -> {
			// failed attempts
			System.out.println("Attempts : " + ATTEMPTS.get());
			if(MAX_ATTEMPTS == nv.intValue()) {
				System.out.printf("User %s is denied access. \n", user.getUserName());
				Platform.exit();
			}
		});
		
		VBox formLayout = new VBox(4);
		formLayout.getChildren().addAll(row1,row2);
		formLayout.setLayoutX(12);
		formLayout.setLayoutY(12);
		
		root.getChildren().addAll(background, formLayout);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
